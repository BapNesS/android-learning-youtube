package com.baptistecarlier.android.appsuper.vm.settings

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val storage = StorageRepository(application)

    val biometricAuth: LiveData<Boolean> = storage.biometricAuthFlow.asLiveData()
    val alerting: LiveData<Boolean> = storage.alertingFlow.asLiveData()

    fun updateBiometricAuth(newValue: Boolean) {
        viewModelScope.launch {
            storage.updateBiometricAuth(newValue)
            Log.d("TODO", "Biometric auth")
        }
    }

    fun updateAlerting(newValue: Boolean) {
        viewModelScope.launch {
            storage.updateAlerting(newValue)
            Log.d("TODO", "Alerting")
        }
    }

}
