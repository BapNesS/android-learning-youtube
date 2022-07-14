package com.baptistecarlier.android.appsuper.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.ui.component.main.MainView
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppSuperTheme {
                    MainView(
                        modifier = Modifier.padding(32.dp),
                        goSettings = { findNavController().navigate(R.id.action_mainFragment_to_settingsFragment) },
                        goWeight = { findNavController().navigate(R.id.action_mainFragment_to_weightFragment) }
                    )
                }
            }
        }
    }
}

