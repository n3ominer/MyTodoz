package com.example.mytodoz.data.repository

import com.example.mytodoz.data.remote.NoteRemoteDataSource
import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.repository.NoteRepository
import com.example.mytodoz.domain.models.Note

class NoteRepositoryImpl(
    val remote: NoteRemoteDataSource = NoteRemoteDataSource()
) : NoteRepository {



    override suspend fun getAllNotes(): List<NoteDto> {
        return remote.fetchNotes()
    }

    override suspend fun getById(id: Int): Note? {
        val noteData = remote.fetchNoteById(id)

        return Note(
            noteData.id,
            noteData.title,
            noteData.content
        )
    }

    override fun addNote(note: Note) {

    }

    override fun deleteNote(note: Note): Boolean {
        return true
    }

    override fun update(updateNote: Note) {

    }

    /*suspend fun getNotes(): List<NoteDto> {
        return this.remote.fetchNotes()
    }


    // TODO: Replace by API calls
    fun getAllNotes(): List<Note> =  notes

    fun getById(id: Int): Note? = notes.find { it.id == id }

    fun addNote(note: Note) = notes.add(note)

    fun deleteNote(note: Note): Boolean{
        notes.removeIf {
            it.id == note.id
        }

        return true
    }

    fun update(updateNote: Note) {
        val index = notes.indexOfFirst { it.id == updateNote.id }
        if (index >= 0) {
            notes[index] = updateNote
        }
    }
    */
}