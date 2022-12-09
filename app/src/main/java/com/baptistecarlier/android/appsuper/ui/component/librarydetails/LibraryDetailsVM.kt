package com.baptistecarlier.android.appsuper.ui.component.librarydetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.baptistecarlier.android.appsuper.domain.model.Library
import com.baptistecarlier.android.appsuper.repository.libs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class LibraryDetailsVM @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = MutableStateFlow<Library?>(null)
    val state: StateFlow<Library?> = _state

    init {
        savedStateHandle.get<Int>("id")?.let {
            _state.value = libs.get(it)
        }
    }


}