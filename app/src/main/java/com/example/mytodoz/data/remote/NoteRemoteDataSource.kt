package com.example.mytodoz.data.remote

import com.example.mytodoz.data.remote.services.NoteApiService
import com.example.mytodoz.network.RetrofitInstance

class NoteRemoteDataSource {
    private val api = RetrofitInstance.api

    private val notesService = api.create(NoteApiService::class.java)

    // HTTP Call to get a list of notes
    suspend fun fetchNotes() = notesService.getAllNotes()

    // HTTP Call to get a note by its id
    suspend fun fetchNoteById(id: Int) = notesService.getNoteById(id)

}