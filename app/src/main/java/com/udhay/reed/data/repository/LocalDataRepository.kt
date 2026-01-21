package com.udhay.reed.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

@Single
class LocalDataRepository(
    private val context: Context
) {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("jwt_token")
    }

    suspend fun storeToken(token: String){
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token;
        }
    }

    val token: Flow<String?> =context.dataStore.data.map { preferences -> preferences[TOKEN_KEY] }

    suspend fun clearToken(){
        context.dataStore.edit { preferences -> preferences.remove(TOKEN_KEY) }
    }

}