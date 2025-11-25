package com.example.mytodoz.domain.repository

import com.example.mytodoz.domain.models.Note

/**
 * Domain-level repository interface for notes.
 * Define the contract here so the app depends on the interface (clean architecture).
 */
interface NoteRepository {
    suspend fun getAllNotes(): List<Note>
    fun getById(id: Int): Note?
    fun addNote(note: Note): Boolean
    fun deleteNote(note: Note): Boolean
    fun update(updateNote: Note)
}
