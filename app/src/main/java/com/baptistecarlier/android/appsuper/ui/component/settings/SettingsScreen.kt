package com.baptistecarlier.android.appsuper.ui.component.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.baptistecarlier.android.appsuper.ui.navigation.Screen

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsVM = hiltViewModel(),
    navigate: (Screen) -> Unit
) {
    val state by viewModel.state.collectAsState()
    state?.let {
        SettingsView(
            modifier,
            it,
            navigate,
            { checked -> viewModel.updateBiometricAuth(checked) },
            { checked -> viewModel.updateAlerting(checked) }
        )
    } ?: run {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

