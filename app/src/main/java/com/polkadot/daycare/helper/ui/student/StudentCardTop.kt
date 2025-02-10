package com.polkadot.daycare.helper.ui.student

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polkadot.daycare.helper.R
import com.polkadot.daycare.helper.data.models.PennyWarbler
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.toBirthdayString
import com.polkadot.daycare.helper.data.models.yearsOld
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme
import com.polkadot.daycare.helper.ui.theme.primaryContainerLight

@Composable
fun StudentCardTop(student: Student, modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(student.imageId),
                contentDescription = null,
                Modifier
                    .clip(RoundedCornerShape(20))
                    .border(2.dp, primaryContainerLight, RoundedCornerShape(20))
                    .weight(0.3F),
                contentScale = ContentScale.FillWidth
            )

            Spacer(Modifier.padding(8.dp))

            Column(
                modifier = Modifier.weight(0.7F, true)
            ) {
                Text(
                    text = student.nickname,
                    style = typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "${student.firstName} ${student.lastName}",
                    style = typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = stringResource(
                        id = R.string.student_age,
                        formatArgs = arrayOf(
                            student.birthday.yearsOld(),
                            student.birthday.toBirthdayString()
                        )
                    ),
                    style = typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
fun StudentCardTopPreview() {
    PolkadotAppTheme {
        Surface {
            StudentCardTop(PennyWarbler)
        }
    }
}
