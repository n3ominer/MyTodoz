package com.example.mytodoz.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodoz.data.repository.NoteRepositoryImpl
import com.example.mytodoz.domain.models.Note
import com.example.mytodoz.domain.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class NotesViewModel(
    private val repo: NoteRepository
): ViewModel() {

    // instance --------------------> .addAll()
    private val _notes = mutableStateListOf<Note>().apply { /*it.*/ addAll(emptyList())}
    val notes: List<Note> = _notes // Cast le mutable state list of ====> list

    private val _remoteNotes = MutableStateFlow<List<Note>>(emptyList())
    val remoteNotes = _remoteNotes.asStateFlow()

    // ============================================================
    // ==================== MOCK DATA ============================
    // ============================================================

    init {
        this.fetchAllNotes()
    }

     fun fetchAllNotes() {
        viewModelScope.launch {
            _remoteNotes.value =  repo.getAllNotes()
        }
    }

    // Add query state
    // Add filter function
    fun addSampleNote() {
        val id = (Random.nextInt(1000) + _notes.size + 1)
        val note = Note(
            id = id,
            title = "New Note #$id",
            content = "This is the content of note $id",
            colorIndex = Random.nextInt(0, 3)
        )
        repo.addNote(note)
        _notes.add(0, note) // Update state
    }

    fun getNoteById(id: Int): Note? = repo.getById(id)

    fun deleteNote(note: Note) {
        val isSuccess = repo.deleteNote(note)
        if (isSuccess) {
            _notes.removeIf { it.id == note.id } // Update state
        }
    }

    fun updateNote(note: Note) {
        val index = notes.indexOfFirst { it.id == note.id }
        if (index >= 0) {
            repo.update(_notes[index])
            // Si l'update est un succès
            _notes[index] = note // Update state
        }
    }

}