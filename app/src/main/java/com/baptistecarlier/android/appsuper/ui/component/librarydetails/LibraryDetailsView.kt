package com.baptistecarlier.android.appsuper.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

@Composable
fun LibraryDetailsView(id: Int, onGoBack: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(
            style = MaterialTheme.typography.h6,
            text = "Detail"
        )
        Text(
            style = MaterialTheme.typography.body1,
            text = "ID (as int) = $id"
        )
        OutlinedButton(onClick = onGoBack) {
            Text("Retour")
        }
    }
}


@Preview()
@Composable
fun DetailViewPreview() {
    AppSuperTheme() {
        LibraryDetailsView(99) { }
    }
}
