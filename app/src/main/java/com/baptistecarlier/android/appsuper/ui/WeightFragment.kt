package com.baptistecarlier.android.appsuper.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.databinding.FragmentMainBinding
import com.baptistecarlier.android.appsuper.databinding.FragmentWeightBinding
import com.baptistecarlier.android.appsuper.vm.WeightViewModel

class WeightFragment : Fragment() {

    private var _binding: FragmentWeightBinding? = null
    // onCreate jusqu'au onDestroyView
    private val binding get() = _binding!!

    private val viewModel: WeightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.switcher.setOnCheckedChangeListener { _, newValue ->
            viewModel.updateTo(newValue)
        }
    }

    private fun initObservers() {
        viewModel.activated.observe(viewLifecycleOwner, Observer {
            binding.switcher?.isChecked = it
            @StringRes val stringRes = if (it) {
                R.string.mesure_enable
            } else {
                R.string.mesure_disable
            }
            binding.textView?.setText(stringRes)
        })
    }

}