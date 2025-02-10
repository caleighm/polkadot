package com.polkadot.daycare.helper.ui.student

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polkadot.daycare.helper.R
import com.polkadot.daycare.helper.data.models.GeraldGiraffe
import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.MamaGiraffe
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.toPrettyString
import com.polkadot.daycare.helper.data.models.yearsOld
import com.polkadot.daycare.helper.ui.composables.PolkadotAppBar
import com.polkadot.daycare.helper.ui.composables.TextWithLabel
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme

@Composable
fun StudentDetailScreen(modifier: Modifier = Modifier, viewModel: StudentDetailViewModel = hiltViewModel()) {
    val result by viewModel.uiState.collectAsStateWithLifecycle()
    if (result is StudentDetailUiState.Success) {
        val success = result as StudentDetailUiState.Success
        StudentDetailScreen(
            student = success.student,
            guardian = success.guardian,
            modifier = modifier
        )
    }
}

@Composable
internal fun StudentDetailScreen(
    student: Student,
    guardian: Guardian,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { PolkadotAppBar(modifier) },
    ) { innerPadding ->
        Box(modifier.padding(innerPadding)) {
            Column(modifier.padding(24.dp)) {
                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    Image(
                        painter = painterResource(student.imageId),
                        contentDescription = student.nickname,
                        modifier = Modifier
                            .size(256.dp)
                            .clip(CircleShape)
                            .border(2.dp, MaterialTheme.colorScheme.outline, CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(Modifier.fillMaxWidth()) {
                    Text(
                        text = student.nickname,
                        style = typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
                    )
                    Text(
                        text = "${student.firstName} ${student.lastName}",
                        style = typography.labelLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(top = 8.dp).fillMaxWidth()
                    )
                    Text(
                        text = "Joined: ${student.joined.toPrettyString()}",
                        style = typography.labelSmall,
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    )

                    TextWithLabel(
                        modifier,
                        label = stringResource(
                            id = R.string.student_details_birthday_header
                        ),
                        body = "${stringResource(
                            id = R.string.student_years_old,
                            formatArgs = arrayOf(student.birthday.yearsOld()))} (${student.birthday.toPrettyString()})"
                    )

                    TextWithLabel(
                        modifier,
                        label = stringResource(
                            id = R.string.student_details_guardian_header
                        ),
                        body = guardian.name
                    )

                    TextWithLabel(
                        modifier,
                        label = stringResource(
                            id = R.string.student_details_guardian_phone_header
                        ),
                        body = guardian.phone
                    )

                    TextWithLabel(
                        modifier,
                        label = stringResource(
                            id = R.string.student_details_guardian_email_header
                        ),
                        body = guardian.email
                    )

                    TextWithLabel(
                        modifier,
                        label = stringResource(
                            id = R.string.student_details_address_header
                        ),
                        body = stringResource(
                            id = R.string.student_details_address_body,
                            formatArgs = arrayOf(
                                student.houseNumber,
                                student.streetName,
                                student.city,
                                student.province,
                                student.postalCode
                            )
                        )
                    )

                    TextWithLabel(
                        modifier,
                        label = stringResource(
                            id = R.string.student_details_allergies_header
                        ),
                        body = student.allergies.ifEmpty { stringResource(
                            id = R.string.text_none
                        ) }
                    )
                }
            }
        }
    }
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PolkadotAppTheme {
        StudentDetailScreen(GeraldGiraffe, MamaGiraffe)
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    PolkadotAppTheme {
        StudentDetailScreen(GeraldGiraffe, MamaGiraffe)
    }
}
