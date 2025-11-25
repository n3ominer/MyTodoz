package com.example.mytodoz.data.db.dao

import androidx.room.Delete
import androidx.room.Query
import com.example.mytodoz.data.db.entities.NoteEntity

interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotesFromDb(): List<NoteEntity>

}