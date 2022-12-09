package com.baptistecarlier.android.appsuper.ui.component.weight

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.baptistecarlier.android.appsuper.ui.component.settings.WeightView

@Composable
fun WeightScreen(modifier: Modifier, viewModel: WeightVM = hiltViewModel()) {
    val activated = viewModel.activated.collectAsState().value
    WeightView(modifier, activated) { viewModel.updateTo(it) }
}
