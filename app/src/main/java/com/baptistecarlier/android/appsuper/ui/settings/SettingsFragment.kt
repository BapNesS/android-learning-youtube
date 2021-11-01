package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.databinding.FragmentLibsBinding
import com.baptistecarlier.android.appsuper.databinding.FragmentSettingsBinding
import com.baptistecarlier.android.appsuper.vm.settings.SettingsViewModel

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    // onCreate jusqu'au onDestroyView
    private val binding get() = _binding!!

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.switcherBiometricauth.setOnCheckedChangeListener { _, newValue ->
            viewModel.updateBiometricAuth(newValue)
        }
        binding.switcherAlerting.setOnCheckedChangeListener { _, newValue ->
            viewModel.updateAlerting(newValue)
        }
        binding.libs.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_libsFragment)
        }
    }

    private fun initObservers() {
        viewModel.biometricAuth.observe(this.viewLifecycleOwner, Observer {
            binding.switcherBiometricauth.isChecked = it
        })
        viewModel.alerting.observe(this.viewLifecycleOwner, Observer {
            binding.switcherAlerting.isChecked = it
        })
    }

}