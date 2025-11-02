package com.example.mytodoz.data.remote.services

import com.example.mytodoz.data.remote.models.NoteDto
import retrofit2.http.GET
import retrofit2.http.Path

interface NoteApiService {
    // https://my-json-server.typicode.com/RamzyK//demo/notes
    @GET("demo/notes")
    suspend fun getAllNotes(): List<NoteDto>

    @GET("demo/notes/{id}")
    suspend fun getNoteById(
        @Path("id") id: Int
    ): NoteDto
}