package com.polkadot.daycare.helper.ui.student

import android.util.Log
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polkadot.daycare.helper.TAG
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.fakeStudents

@Composable
fun StudentScreen(modifier: Modifier = Modifier, viewModel: StudentViewModel = hiltViewModel()) {
    val students by viewModel.uiState.collectAsStateWithLifecycle()
    if (students is StudentUiState.Success) {
        StudentScreen(
            students = (students as StudentUiState.Success).data,
            onSave = viewModel::addStudent,
            modifier = modifier
        )
    }
}

@Composable
internal fun StudentScreen(
    students: List<Student>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        students.forEach {
            StudentCardTop(it, Modifier.padding(4.dp))
        }

        var nameStudent by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = nameStudent,
                onValueChange = { nameStudent = it }
            )

            Button(modifier = Modifier.width(96.dp), onClick = { onSave(nameStudent) }) {
                Text("Save")
            }
        }
    }
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PolkadotAppTheme {
        StudentScreen(fakeStudents, onSave = {})
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    PolkadotAppTheme {
        StudentScreen(fakeStudents, onSave = {})
    }
}
