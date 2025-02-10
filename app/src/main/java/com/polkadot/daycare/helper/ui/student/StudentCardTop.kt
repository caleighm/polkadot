package com.polkadot.daycare.helper.ui.student

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polkadot.daycare.helper.R
import com.polkadot.daycare.helper.data.models.PennyWarbler
import com.polkadot.daycare.helper.data.models.StudentOverview
import com.polkadot.daycare.helper.data.models.getBasics
import com.polkadot.daycare.helper.data.models.toPrettyString
import com.polkadot.daycare.helper.data.models.yearsOld
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme

@Composable
fun StudentCardTop(
    student: StudentOverview,
    modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(student.imageId),
                contentDescription = null,
                Modifier.height(120.dp).width(120.dp),
                contentScale = ContentScale.Crop
            )

            Column {
                Column(Modifier.padding(12.dp)) {
                    Text(
                        text = student.nickname.ifEmpty { student.firstName },
                        style = typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Text(
                        text = "${student.firstName} ${student.lastName}",
                        style = typography.bodySmall,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "${stringResource(
                            id = R.string.student_years_old,
                            formatArgs = arrayOf(student.birthday.yearsOld())
                        )} (${student.birthday.toPrettyString()})",
                        style = typography.bodySmall
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun StudentCardTopPreview() {
    PolkadotAppTheme {
        Surface {
            StudentCardTop(PennyWarbler.getBasics())
        }
    }
}
