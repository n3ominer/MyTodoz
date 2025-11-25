package com.example.mytodoz.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long,
    val colorIndex: Int
)