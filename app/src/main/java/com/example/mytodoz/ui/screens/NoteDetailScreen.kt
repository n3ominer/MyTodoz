package com.example.mytodoz.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytodoz.ui.components.TopBar
import com.example.mytodoz.viewModels.NotesViewModel

@Composable
fun NoteDetailScreen(
    noteId: Int,
    viewModel: NotesViewModel,
    onBackClick: () -> Unit,
    folderName: String = "My notes",
    onSettingClick: () -> Unit
){
    val note = viewModel.getNoteById(noteId)
    if(note == null){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Note est introuvable")
            Button(onClick = onBackClick) {
                Text("Retour")
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()){
            TopBar(
                title = "",
                showBackButton = true,
                onBackClick = onBackClick,
                onSettingClick = onSettingClick
            )

            Column(modifier = Modifier.fillMaxSize().padding(14.dp)) {
                Text(
                    "20th Feb 2025 11:53 AM",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    note.title,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Composant pour le folder
                Surface(
                    color = Color(0xFFF5C6F9),
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 2.dp
                ) {
                    Text(
                        folderName,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    note.content,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}