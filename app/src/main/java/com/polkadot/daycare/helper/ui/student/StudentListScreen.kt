package com.polkadot.daycare.helper.ui.student

import androidx.compose.foundation.clickable
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polkadot.daycare.helper.R
import com.polkadot.daycare.helper.data.models.StudentOverview
import com.polkadot.daycare.helper.data.models.fakeStudents
import com.polkadot.daycare.helper.ui.composables.PolkadotAppBar
import java.util.Locale

@Composable
fun StudentsScreen(
    modifier: Modifier = Modifier,
    viewModel: StudentListViewModel = hiltViewModel(),
    onNavigateToStudentDetails: (studentId: Int, guardianId: Int) -> Unit) {
    val students by viewModel.uiState.collectAsStateWithLifecycle()
    if (students is StudentUiState.Success) {
        StudentsScreen(
            students = (students as StudentUiState.Success).data,
            onSave = viewModel::addStudent,
            onNavigateToStudentDetails = onNavigateToStudentDetails,
            modifier = modifier
        )
    }
}

@Composable
internal fun StudentsScreen(
    students: List<StudentOverview>,
    onSave: (name: String) -> Unit,
    onNavigateToStudentDetails: (studentId: Int, guardianId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { PolkadotAppBar(modifier) },
    ) { innerPadding ->
        Column(modifier.padding(innerPadding)) {
            Text(
                text = stringResource(
                    id = R.string.student_title
                ),
                style = typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            Row {
                Column(modifier) {
                    students.forEach {
                        StudentCardTop(it, Modifier.clickable {
                            onNavigateToStudentDetails(it.id, it.guardianId)
                        })
                    }
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
        StudentsScreen(fakeStudents, onSave = {}, onNavigateToStudentDetails = { _: Int, _: Int -> } )
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    PolkadotAppTheme {
        StudentsScreen(fakeStudents, onSave = {}, onNavigateToStudentDetails = { _: Int, _: Int -> } )
    }
}
