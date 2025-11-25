package com.example.mytodoz.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mytodoz.data.db.entities.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotesFromDb(): List<NoteEntity>

    @Insert
    fun insertOneNote(note: NoteEntity)

}