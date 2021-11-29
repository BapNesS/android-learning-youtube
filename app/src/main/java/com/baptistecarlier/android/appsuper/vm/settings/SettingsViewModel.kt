package com.baptistecarlier.android.appsuper.vm.settings

import android.util.Log
import androidx.lifecycle.*
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject
constructor(
    private val storageRepository: StorageRepository
) : ViewModel() {

    val biometricAuth: LiveData<Boolean> = storageRepository.biometricAuthFlow.asLiveData()
    val alerting: LiveData<Boolean> = storageRepository.alertingFlow.asLiveData()

    fun updateBiometricAuth(newValue: Boolean) {
        viewModelScope.launch {
            storageRepository.updateBiometricAuth(newValue)
            Log.d("TODO", "Biometric auth")
        }
    }

    fun updateAlerting(newValue: Boolean) {
        viewModelScope.launch {
            storageRepository.updateAlerting(newValue)
            Log.d("TODO", "Alerting")
        }
    }

}
