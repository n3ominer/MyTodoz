package com.example.mytodoz.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.mytodoz.data.db.entities.NoteEntity

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotesFromDb(): List<NoteEntity>


}