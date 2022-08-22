package de.rbuchwald.dogprofilepage.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DogProfileStats(
    amount: String,
    text: String
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = amount)
        Text(text = text, fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
    }

}