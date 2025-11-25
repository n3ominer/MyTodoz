package com.example.mytodoz.data.remote

import com.example.mytodoz.domain.models.dto.NoteDto
import retrofit2.http.GET

interface NoteApiService {

    @GET("notes")
    suspend fun getNotes(): List<NoteDto>



    fun getNoteById()

}