package com.example.mytodoz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodoz.data.datastore.DataStoreManager
import com.example.mytodoz.data.db.AppDataBase
import com.example.mytodoz.data.db.provider.DataBaseProvider
import com.example.mytodoz.data.repository.NoteRepositoryImpl
import com.example.mytodoz.ui.navigation.NavGraph
import com.example.mytodoz.ui.theme.MyTodozTheme
import com.example.mytodoz.viewModels.NotesViewModel
import com.example.mytodoz.viewModels.SettingsViewModel

class MainActivity : ComponentActivity() {

    private lateinit var db: AppDataBase
    private lateinit var notesRepository: NoteRepositoryImpl
    private lateinit var notesVm: NotesViewModel

    private lateinit var dataStoreManager: DataStoreManager
    private lateinit var settingVm: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = DataBaseProvider.provide(this)
        notesRepository = NoteRepositoryImpl(noteDao = db.notesDao())
        dataStoreManager = DataStoreManager(this)
        settingVm = SettingsViewModel(dataStoreManager)
        notesVm = NotesViewModel(repo = notesRepository)

        setContent {
            MyTodozTheme {

                NavGraph(
                    viewModel = notesVm,
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