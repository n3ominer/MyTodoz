package com.example.mytodoz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytodoz.data.db.dao.NoteDao
import com.example.mytodoz.data.db.entities.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class AppDataBase:  RoomDatabase() {
    abstract fun noteDao(): NoteDao
}