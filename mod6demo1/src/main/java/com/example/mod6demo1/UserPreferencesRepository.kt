package com.example.mod6demo1

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(private val context: Context) {

    private val Context.datastore by preferencesDataStore(name = "user_preferences")
    private val KEY_BG_COLOR = intPreferencesKey("KEY_BG_COLOR")

    //enregistrer la couleur
    suspend fun saveColor(color: Color) {
        context.datastore.edit { pref ->
            pref[KEY_BG_COLOR] = color.toArgb()
        }
    }

    //récupérer la couleur
    suspend fun getColor(): Flow<Color> {
        return context.datastore.data.map {pref ->
            Color(pref[KEY_BG_COLOR] ?: Color.White.toArgb())
        }
    }


}