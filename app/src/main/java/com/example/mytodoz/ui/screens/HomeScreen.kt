package com.example.mytodoz.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytodoz.ui.components.BottomBar
import com.example.mytodoz.ui.components.NoteCard
import com.example.mytodoz.ui.components.SearchBar
import com.example.mytodoz.ui.components.TopBar
import com.example.mytodoz.viewModels.NotesViewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel,
    onOpenNote: (Int) -> Unit, //
    onOpenSettings: () -> Unit,
    folderName: String = "My notes",
) {
    val remoteNotes by viewModel.remoteNotes.collectAsState()
    Surface {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Column(modifier = modifier.fillMaxSize().padding(12.dp)) {
                TopBar(
                    title = "Just Do It!",
                    showBackButton = false,
                    onBackClick = {},
                    onSettingClick = {}
                  )

                Text(
                    "${remoteNotes.size} Notes",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(8.dp)
                )

                // SearchBar
                SearchBar(
                    query = "",
                    onQueryChanged = {  },
                    onFilterClick = { }
                )

                Text(
                    folderName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(8.dp)
                )

                LazyVerticalGrid(
                    modifier = Modifier.padding(top = 4.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(remoteNotes) { note ->
                        NoteCard(note) { onOpenNote(note.id) }
                    }
                }
            }

            BottomBar({},{}, onOpenSettings)
        }
    }
}


