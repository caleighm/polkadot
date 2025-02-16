package com.polkadot.daycare.helper.ui.enrollment

import androidx.compose.foundation.clickable
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
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
fun EnrollmentScreen(
    modifier: Modifier = Modifier,
    viewModel: EnrollmentViewModel = hiltViewModel()) {
    EnrollmentScreen(
        onSave = viewModel::addStudent,
        modifier = modifier
    )
}

@Composable
internal fun EnrollmentScreen(
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { PolkadotAppBar(modifier) },
    ) { innerPadding ->
        Column(modifier.padding(innerPadding)) {
            Text(
                text = stringResource(
                    id = R.string.enrollment_title
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
                    var nameStudent by remember { mutableStateOf("Compose") }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
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
        }
    }
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PolkadotAppTheme {
        EnrollmentScreen(onSave = {})
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    PolkadotAppTheme {
        EnrollmentScreen(onSave = {})
    }
}
