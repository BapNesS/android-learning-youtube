package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.domain.model.Library
import com.baptistecarlier.android.appsuper.repository.libs
import com.baptistecarlier.android.appsuper.ui.component.settings.ListLibsView
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme

class LibsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ComposeView).init()
    }

    private fun ComposeView.init() {
        this.setContent {
            AppSuperTheme {
                ListLibsView(libs) { onItemClick(it) }
            }
        }
    }

    private fun onItemClick(library: Library) {
        val position = libs.indexOf(library)
        val direction = LibsFragmentDirections.actionLibsFragmentToLibDetailsFragment(
            position = position
        )
        findNavController().navigate(direction)
    }
}















