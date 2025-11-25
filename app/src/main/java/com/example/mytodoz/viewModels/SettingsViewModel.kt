package com.example.mytodoz.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodoz.data.datastore.DataStoreManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val dataStoreManager: DataStoreManager
): ViewModel() {

    val isDarkMode = dataStoreManager.darkModeFlow.stateIn(
        viewModelScope, // Scope
        SharingStarted.Lazily,
        false
    )

    fun toggleDarkMode(state: Boolean) {
        viewModelScope.launch {
            dataStoreManager.saveDarModePref(state)
        }
    }
}