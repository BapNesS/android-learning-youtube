package com.baptistecarlier.android.appsuper.ui.component.settings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.baptistecarlier.android.appsuper.domain.model.Library
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

@Composable
fun ListLibsView(list: List<Library>, onItemClick: (Library) -> Unit) {
    LazyColumn {
        items(list) {
            LibItem(it) { onItemClick(it) }
        }
    }
}

@Preview
@Composable
fun ListLibsViewPreview() {
    AppSuperTheme() {
        val list = (0..20).map {
            Library("Title $it", "Author", "Licence")
        }
        ListLibsView(list) { }
    }
}
