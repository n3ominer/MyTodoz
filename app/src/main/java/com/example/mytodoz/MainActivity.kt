package com.example.mytodoz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodoz.data.datastore.DataStoreManager
import com.example.mytodoz.data.repository.NoteRepositoryImpl
import com.example.mytodoz.ui.navigation.NavGraph
import com.example.mytodoz.ui.theme.MyTodozTheme
import com.example.mytodoz.viewModels.NotesViewModel
import com.example.mytodoz.viewModels.SettingsViewModel

class MainActivity : ComponentActivity() {

    private val notesRepository: NoteRepositoryImpl = NoteRepositoryImpl()

    private val viewModel: NotesViewModel = NotesViewModel(repo = notesRepository)

    private lateinit var dataStoreManager: DataStoreManager
    private lateinit var settingVm: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataStoreManager = DataStoreManager(this)
        settingVm = SettingsViewModel(dataStoreManager)

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