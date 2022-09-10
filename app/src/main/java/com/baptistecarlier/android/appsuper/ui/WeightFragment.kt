package com.baptistecarlier.android.appsuper.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.baptistecarlier.android.appsuper.ui.component.settings.WeightView
import com.baptistecarlier.android.appsuper.vm.WeightViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeightFragment : Fragment() {

    private val viewModel: WeightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ComposeView).init(viewModel)
    }

    private fun ComposeView.init(viewModel: WeightViewModel) = setContent {
        Column {
            val activated = viewModel.activated.collectAsState().value
            WeightView(activated) { viewModel.updateTo(it) }
        }
    }

}
