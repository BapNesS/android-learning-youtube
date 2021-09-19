package com.baptistecarlier.android.appsuper.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.settings: DataStore<Preferences> by preferencesDataStore(name = "settings")

class StorageRepository(context: Context) {

    companion object {
        val MESURE_WEIGHT : Preferences.Key<Boolean> = booleanPreferencesKey("MESURE_WEIGHT")
        val BIOMETRIC_AUTH : Preferences.Key<Boolean> = booleanPreferencesKey("BIOMETRIC_AUTH")
        val ALERTING : Preferences.Key<Boolean> = booleanPreferencesKey("ALERT")
    }

    private val settings: DataStore<Preferences> = context.settings

    suspend fun updateMesureWeight(newName: Boolean) {
        settings.edit {
            it[MESURE_WEIGHT] = newName
        }
    }

    val mesureWeightFlow: Flow<Boolean> = settings.data.catch {
        if (it is IOException) {
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map { preferences ->
        preferences[MESURE_WEIGHT] ?: true
    }

    suspend fun updateBiometricAuth(newName: Boolean) {
        settings.edit {
            it[BIOMETRIC_AUTH] = newName
        }
    }

    val biometricAuthFlow: Flow<Boolean> = settings.data.catch {
        if (it is IOException) {
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map { preferences ->
        preferences[BIOMETRIC_AUTH] ?: false
    }

    suspend fun updateAlerting(newName: Boolean) {
        settings.edit {
            it[ALERTING] = newName
        }
    }

    val alertingFlow: Flow<Boolean> = settings.data.catch {
        if (it is IOException) {
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map { preferences ->
        preferences[ALERTING] ?: false
    }

}

