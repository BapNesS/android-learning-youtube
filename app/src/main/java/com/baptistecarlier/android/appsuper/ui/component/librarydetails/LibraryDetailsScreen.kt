package com.baptistecarlier.android.appsuper.ui.component.librarydetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
fun LibraryDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: LibraryDetailsVM = hiltViewModel()
) {

    val state = viewModel.state.collectAsState().value
    state?.let {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                style = MaterialTheme.typography.h6,
                text = it.title
            )
            Text(
                style = MaterialTheme.typography.body1,
                text = it.author
            )
            Text(
                style = MaterialTheme.typography.body2,
                text = it.licence
            )
        }
    }

}

