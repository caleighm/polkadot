package com.polkadot.daycare.helper.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme

@Composable
fun TextWithLabel(modifier: Modifier, label: String, body: List<String?>) {
    Row(modifier = modifier.padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            style = typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(60.dp)
        )
        Spacer(Modifier.size(8.dp))
        for (line in body) {
            if (line != null) {
                Text(
                    text = line,
                    style = typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun TextWithLabel(modifier: Modifier, label: String, body: String?) {
    TextWithLabel(modifier, label, listOf(body))
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PolkadotAppTheme {
        Column {
            TextWithLabel(Modifier, "Label 1", "Here is a lot of text we need to label")
            TextWithLabel(Modifier, "Label 2", null)
            TextWithLabel(Modifier, "Label 3", listOf("Text 1", "Text 2", "Text 3"))
            TextWithLabel(Modifier, "Label 4", listOf(null))
        }
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    PolkadotAppTheme {
        Column {
            TextWithLabel(Modifier, "Label 1", "Here is a lot of text we need to label")
            TextWithLabel(Modifier, "Label 2", null)
            TextWithLabel(Modifier, "Label 3", listOf("Text 1", "Text 2", "Text 3"))
            TextWithLabel(Modifier, "Label 4", listOf(null))
        }
    }
}