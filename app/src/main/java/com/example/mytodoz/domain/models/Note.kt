package com.example.mytodoz.domain.models

import java.time.Instant

data class Note(
    val id: Int,
    val title: String,
    val content: String,
                            // UNIT time | nb de secondes depuis 01/01/1970
    val createdAt: Long = Instant.now().epochSecond, // On récupère le nb de sec depuis la création de la note
    val colorIndex: Int = 0
)