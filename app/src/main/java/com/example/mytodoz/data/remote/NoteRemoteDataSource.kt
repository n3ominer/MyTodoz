package com.example.mytodoz.data.remote

import com.example.mytodoz.data.remote.services.NoteApiService
import com.example.mytodoz.network.RetrofitInstance
import retrofit2.Retrofit

open class NoteRemoteDataSource(
    api: Retrofit = RetrofitInstance.api
) {
    private val notesService = api.create(NoteApiService::class.java)

    // HTTP Call to get a list of notes
    open suspend fun fetchNotes() = notesService.getAllNotes()

    // HTTP Call to get a note by its id
    open suspend fun fetchNoteById(id: Int) = notesService.getNoteById(id)

}