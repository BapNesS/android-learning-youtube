package com.baptistecarlier.android.appsuper.ui.component.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.ui.navigation.Screen
import com.baptistecarlier.android.appsuper.ui.navigation.Settings
import com.baptistecarlier.android.appsuper.ui.navigation.Weight


@Composable
fun MainView(modifier: Modifier = Modifier, navigate: (Screen) -> Unit) {
    Column(modifier = modifier) {
        Button(onClick = { navigate(Settings) }) {
            Text(stringResource(id = R.string.settings))
        }
        Button(onClick = { navigate(Weight) }) {
            Text(stringResource(id = R.string.weight))
        }
        Text("Tout simplement")
    }
}