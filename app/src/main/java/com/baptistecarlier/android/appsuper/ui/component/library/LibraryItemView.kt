package com.baptistecarlier.android.appsuper.ui.component.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baptistecarlier.android.appsuper.domain.model.Library
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

@Composable
fun LibraryItemView(item: Library, onClick: () -> Unit) {
    Text(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(16.dp),
        text = item.title
    )
}

@Preview
@Composable
fun LibraryItemViewPreview() {
    AppSuperTheme {
        LibraryItemView(item = Library("Titre", "Auteur", "Licence")) { }
    }
}



