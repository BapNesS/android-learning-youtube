package com.baptistecarlier.android.appsuper.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel
@Inject
constructor(
    private val storageRepository: StorageRepository
) : ViewModel() {

    private val _activated = MutableLiveData(false)
    val activated: LiveData<Boolean> = _activated

    init {
        storageRepository.mesureWeightFlow.onEach {
            _activated.postValue( it )
        }.launchIn(viewModelScope)
    }

    fun updateTo(newValue: Boolean) {
        viewModelScope.launch {
            storageRepository.updateMesureWeight(newValue)
        }
    }

}

