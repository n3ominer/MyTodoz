package com.example.mytodoz.data.repository

import com.example.mytodoz.data.remote.NoteRemoteDataSource
import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.repository.NoteRepository
import com.example.mytodoz.domain.models.Note

class NoteRepositoryImpl(
    // Add DAO
    val remote: NoteRemoteDataSource = NoteRemoteDataSource()
) : NoteRepository {



    override suspend fun getAllNotes(): List<NoteDto> {
        // Fetch data --> 500
        // Save data in DB

        // ---> If fetch data is empty : check in DB

        // Return data

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
}