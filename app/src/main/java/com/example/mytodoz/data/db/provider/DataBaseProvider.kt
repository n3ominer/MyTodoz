package com.example.mytodoz.data.db.provider

import android.content.Context
import androidx.room.Room
import com.example.mytodoz.data.db.AppDataBase

object DataBaseProvider {

    fun provide(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "notes_db"
        ).build()
    }
}