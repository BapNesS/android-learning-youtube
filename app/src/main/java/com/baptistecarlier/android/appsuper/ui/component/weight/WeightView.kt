package com.baptistecarlier.android.appsuper.ui.component.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

@Composable
fun WeightView(
    modifier: Modifier = Modifier,
    activated: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    val stringRes = if (activated) {
        R.string.mesure_enable
    } else {
        R.string.mesure_disable
    }

    Column(modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            text = stringResource(id = stringRes)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.mesure)
            )
            Switch(checked = activated, onCheckedChange = {
                onCheckedChange(it)
            })
        }
    }
}

@Preview
@Composable
fun WeightViewPreview() {
    AppSuperTheme {
        WeightView(activated = true) { }
    }
}