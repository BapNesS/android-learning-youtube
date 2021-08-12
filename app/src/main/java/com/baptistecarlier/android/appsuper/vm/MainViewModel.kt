package com.baptistecarlier.android.appsuper.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val storage = StorageRepository(application)

    private val _activated = MutableLiveData(false)
    val activated: LiveData<Boolean> = _activated

    init {
        storage.mesureWeightFlow.onEach {
            _activated.postValue( it )
        }.launchIn(viewModelScope)
    }

    fun updateTo(newValue: Boolean) {
        viewModelScope.launch {
            storage.updateMesureWeight(newValue)
        }
    }

}

