package com.example.mytodoz.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_preferences")

class DataStoreManager(private val context: Context) {

    // GET DATA FROM DS
    val darkModeFlow: Flow<Boolean> = context.dataStore.data.map { pref ->
        pref[UserPreferences.DARK_MODE] ?: false
    }

    // SET DATA IN DS
    suspend fun saveDarModePref(newState: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[UserPreferences.DARK_MODE] = newState
        }
    }
}