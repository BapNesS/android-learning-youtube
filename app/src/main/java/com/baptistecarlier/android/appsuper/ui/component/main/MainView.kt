package com.baptistecarlier.android.appsuper.ui.component.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.baptistecarlier.android.appsuper.R


@Composable
fun MainView(modifier: Modifier = Modifier, goSettings: () -> Unit, goWeight: () -> Unit) {
    Column(modifier = modifier) {
        Button(onClick = goSettings) {
            Text(stringResource(id = R.string.settings))
        }
        Button(onClick = goWeight) {
            Text(stringResource(id = R.string.weight))
        }
        Text("Tout simplement")
    }
}