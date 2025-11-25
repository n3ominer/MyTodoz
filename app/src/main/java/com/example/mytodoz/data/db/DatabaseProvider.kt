package com.example.mytodoz.data.db

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    fun provide(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "notes_db"
        ).build()
    }
}