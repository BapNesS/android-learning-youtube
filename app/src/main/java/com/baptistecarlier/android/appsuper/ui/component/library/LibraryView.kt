package com.baptistecarlier.android.appsuper.ui.component.library

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.baptistecarlier.android.appsuper.domain.model.Library
import com.baptistecarlier.android.appsuper.ui.component.settings.LibraryItemView
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

@Composable
fun LibraryView(list: List<Library>, onItemClick: (Library) -> Unit) {
    LazyColumn {
        items(list) {
            LibraryItemView(it) { onItemClick(it) }
        }
    }
}

@Preview
@Composable
fun LibraryViewPreview() {
    AppSuperTheme() {
        val list = (0..20).map {
            Library("Title $it", "Author", "Licence")
        }
        LibraryView(list) { }
    }
}
