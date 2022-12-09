package com.baptistecarlier.android.appsuper.ui.component.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.ui.navigation.Library
import com.baptistecarlier.android.appsuper.ui.navigation.Screen

@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    state: SettingsUiState,
    navigate: (Screen) -> Unit,
    onChangeBiometric: (Boolean) -> Unit,
    onChangeAlerting: (Boolean) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.settings_biometricauth)
            )
            Switch(checked = state.biometricAuth, onCheckedChange = onChangeBiometric)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.settings_alerting)
            )
            Switch(checked = state.alerting, onCheckedChange = onChangeAlerting)
        }
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navigate(Library) }
        ) {
            Text(stringResource(id = R.string.libs))
        }
    }
}
