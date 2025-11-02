package com.example.mytodoz.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodoz.domain.models.Note
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NoteCard(note: Note, onClick: () -> Unit) {

    val bg = when(note.colorIndex % 4) {
        0 -> Color(0xFFA264DE) // violet clair
        1 -> Color(0xFFD9CBEF) // autre nuance
        2 -> Color(0xFF7655ED) // autre nuance
        else -> Color(0xFFE9D9F7)
    }

    Surface(
        modifier = Modifier.padding(8.dp)
            .size(width = 160.dp, height = 120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        color = bg,
        shadowElevation = 4.dp,
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = note.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = note.content, fontSize = 12.sp)
        }
    }

}

@Preview
@Composable
fun NoteCardPreview() {
    NoteCard(
        note = Note(
            id = 1,
            title = "Sample Note",
            content = "This is a sample note content.",
            colorIndex = 2
        ),
        onClick = {}
    )
}