package com.example.mytodoz.viewModels

import NoteUseCases
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodoz.data.mapper.mapNoteDtoToNote
import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.models.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val useCases: NoteUseCases
): ViewModel() {

    // ============================================================
    // ==================== REMOTE DATA ============================
    // ============================================================
    private val _remoteNotes = MutableStateFlow<List<Note>>(emptyList())
    val remoteNotes = _remoteNotes.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        fetchNotesFromRepo()
    }

    fun fetchNotesFromRepo() {
        viewModelScope.launch {
            try {
                _remoteNotes.value = useCases.getAllNotes().map {
                    mapNoteDtoToNote(it)
                }
            } catch (e: Exception) {
                _error.value = "Erreur de chargement des données. Error: ${e.message}"
            }
        }
    }

    
    fun getNoteById(id: Int): Note? = _remoteNotes.value.find { it.id == id }

}