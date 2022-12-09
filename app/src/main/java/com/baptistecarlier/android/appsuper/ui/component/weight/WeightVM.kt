package com.baptistecarlier.android.appsuper.ui.component.weight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightVM @Inject constructor(
    private val storageRepository: StorageRepository
) : ViewModel() {

    val activated: StateFlow<Boolean> =
        storageRepository.mesureWeightFlow.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            false
        )

    fun updateTo(newValue: Boolean) {
        viewModelScope.launch {
            storageRepository.updateMesureWeight(newValue)
        }
    }

}

