package com.baptistecarlier.android.appsuper.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

@Composable
fun HomeView(onGoDetail: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text("Home")
        Button(onClick = onGoDetail) {
            Text("Detail")
        }
    }
}

@Preview()
@Composable
fun HomeViewPreview() {
    AppSuperTheme() {
        HomeView { }
    }
}
