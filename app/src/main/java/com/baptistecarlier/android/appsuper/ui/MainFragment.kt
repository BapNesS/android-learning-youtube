package com.baptistecarlier.android.appsuper.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    // onCreate jusqu'au onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
        }
        binding.weight.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_weightFragment)
        }
    }

}