package com.example.mytodoz.data.remote

import com.example.mytodoz.data.network.RetrofitClient

class NoteRemoteDataSource {
    private val noteService = RetrofitClient.api.create(NoteApiService::class.java)

    suspend fun fetchNotes() = noteService.getNotes()

    // Add toutes les fonctions nécéssaires
}