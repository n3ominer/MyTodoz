package com.example.mytodoz

import com.example.mytodoz.domain.usecase.NoteUseCases
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodoz.data.datastore.DataStoreManager
import com.example.mytodoz.data.repository.NoteRepositoryImpl
import com.example.mytodoz.domain.usecase.GetAllNotesUseCase
import com.example.mytodoz.domain.usecase.GetNoteByIdUseCase
import com.example.mytodoz.ui.navigation.NavGraph
import com.example.mytodoz.ui.theme.MyTodozTheme
import com.example.mytodoz.viewModels.NotesViewModel
import com.example.mytodoz.viewModels.SettingsViewModel

class MainActivity : ComponentActivity() {

    private val notesRepository: NoteRepositoryImpl = NoteRepositoryImpl()
    private val noteUseCases: NoteUseCases = NoteUseCases(
        getAllNotes = GetAllNotesUseCase(notesRepository),
        getNoteById = GetNoteByIdUseCase(notesRepository)
    )

    private lateinit var dataStore: DataStoreManager

    private lateinit var settingVm: SettingsViewModel
    private val viewModel: NotesViewModel = NotesViewModel(useCases = noteUseCases)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataStore = DataStoreManager(this)
        settingVm = SettingsViewModel(dataStore)

        setContent {
            MyTodozTheme {

                NavGraph(
                    viewModel = viewModel,
                    settingsViewModel = settingVm
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TodozAppPreview() {
}