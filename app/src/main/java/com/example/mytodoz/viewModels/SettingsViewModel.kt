package com.example.mytodoz.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodoz.data.datastore.DataStoreManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    val datastore: DataStoreManager
) : ViewModel() {

    val isDarkMode = datastore.darModeFlow.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        false
    )


    // Fonction qui sera appellée par la vue, quand on clique sur le switch
    fun toggleDarkMode(state: Boolean) {
        viewModelScope.launch {
            datastore.saveDarkMode(state)
        }
    }
}