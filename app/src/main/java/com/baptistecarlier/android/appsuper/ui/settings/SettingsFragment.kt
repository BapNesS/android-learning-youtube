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
import com.baptistecarlier.android.appsuper.vm.settings.SettingsViewModel

class SettingsFragment : Fragment() {

    private var biometricAuthSwitchCompat: SwitchCompat? = null
    private var alertingSwitchCompat: SwitchCompat? = null
    private var libsButton: Button? = null

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        biometricAuthSwitchCompat = view?.findViewById(R.id.switcher_biometricauth)
        alertingSwitchCompat = view?.findViewById(R.id.switcher_alerting)
        libsButton = view?.findViewById(R.id.libs)
    }

    private fun initListeners() {
        biometricAuthSwitchCompat?.setOnCheckedChangeListener { _, newValue ->
            viewModel.updateBiometricAuth(newValue)
        }
        alertingSwitchCompat?.setOnCheckedChangeListener { _, newValue ->
            viewModel.updateAlerting(newValue)
        }
        libsButton?.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_libsFragment)
        }
    }

    private fun initObservers() {
        viewModel.biometricAuth.observe(this.viewLifecycleOwner, Observer {
            biometricAuthSwitchCompat?.isChecked = it
        })
        viewModel.alerting.observe(this.viewLifecycleOwner, Observer {
            alertingSwitchCompat?.isChecked = it
        })
    }

}