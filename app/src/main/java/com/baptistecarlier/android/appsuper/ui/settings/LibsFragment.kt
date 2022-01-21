package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.adapter.LibsAdapter
import com.baptistecarlier.android.appsuper.databinding.FragmentLibsBinding
import com.baptistecarlier.android.appsuper.domain.model.Library
import com.baptistecarlier.android.appsuper.repository.libs

class LibsFragment : Fragment(), LibsAdapter.ItemClickListener {

    private var _binding: FragmentLibsBinding? = null
    // onCreate jusqu'au onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.recyclerView.adapter = LibsAdapter(libs, this)
    }

    override fun onItemClick(library: Library) {
        val position = libs.indexOf(library)
        val direction = LibsFragmentDirections.actionLibsFragmentToLibDetailsFragment(
            position = position
        )
        findNavController().navigate(direction)
    }

}

