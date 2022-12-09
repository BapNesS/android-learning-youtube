package com.baptistecarlier.android.appsuper.ui.component.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsVM @Inject constructor(
    private val storageRepository: StorageRepository
) : ViewModel() {

    private var _state = MutableStateFlow<SettingsUiState?>(null)
    val state: StateFlow<SettingsUiState?> = _state

    init {
        storageRepository.biometricAuthFlow
            .combine(storageRepository.alertingFlow) { biometricAuth, alerting ->
                _state.value = SettingsUiState(
                    biometricAuth = biometricAuth,
                    alerting = alerting
                )
            }.launchIn(viewModelScope)
    }

    fun updateBiometricAuth(newValue: Boolean) = viewModelScope.launch {
        storageRepository.updateBiometricAuth(newValue)
    }

    fun updateAlerting(newValue: Boolean) = viewModelScope.launch {
        storageRepository.updateAlerting(newValue)
    }

}

