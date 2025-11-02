package com.example.mytodoz.data.remote.models

data class NoteDto(
    val id: Int,
    val title: String,
    val content: String,
    val colorIndex: Int = 0
)