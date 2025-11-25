package com.example.mytodoz.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// <String, Any>
private val  Context.dataStore by preferencesDataStore("user_prefs")

class DataStoreManager(val context: Context) {

    // GET DATA FROM DS
    val darModeFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[UserPreferences.DARK_MODE] ?: false
    }


    // SET DATA IN DS
    suspend fun saveDarkMode(newState: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[UserPreferences.DARK_MODE] = newState
        }
    }

}