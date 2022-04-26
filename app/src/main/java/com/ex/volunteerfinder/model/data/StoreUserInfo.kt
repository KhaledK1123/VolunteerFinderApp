package com.ex.volunteerfinder.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserInfo(private val context: Context) {
    companion object {
        private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("userEmail")
        val USERNAME = stringPreferencesKey("username")
        val NAME = stringPreferencesKey("name")
        val EMAIL = stringPreferencesKey("email")
        val CITY = stringPreferencesKey("city")
        val STATE = stringPreferencesKey("state")
        val ZIPCODE = intPreferencesKey("zipcode")
    }

    //get the saved email
    val getEmail: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[EMAIL] ?: "Person"
        }
    //save email into datastore
    suspend fun saveEmail(email: String) {
        context.dataStoree.edit { preferences ->
            preferences[EMAIL] = email
        }
    }
    val getUsername: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[USERNAME] ?: "Person"
        }
    //save email into datastore
    suspend fun saveUsername(username: String) {
        context.dataStoree.edit { preferences ->
            preferences[USERNAME] = username
        }
    }
    val getName: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[NAME] ?: "Person"
        }
    //save email into datastore
    suspend fun saveName(name: String) {
        context.dataStoree.edit { preferences ->
            preferences[NAME] = name
        }
    }

    val getCity: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[CITY] ?: "Person"
        }
    //save email into datastore
    suspend fun saveCity(city: String) {
        context.dataStoree.edit { preferences ->
            preferences[CITY] = city
        }
    }
    val getState: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[STATE] ?: "Person"
        }
    //save email into datastore
    suspend fun saveState(state: String) {
        context.dataStoree.edit { preferences ->
            preferences[STATE] = state
        }
    }
    val getZipCode: Flow<Int?> = context.dataStoree.data
        .map { preferences ->
            preferences[ZIPCODE] ?: 0
        }
    //save email into datastore
    suspend fun saveZipCode(zipcode: Int) {
        context.dataStoree.edit { preferences ->
            preferences[ZIPCODE] = zipcode
        }
    }

}