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
import com.baptistecarlier.android.appsuper.vm.MainViewModel

class MainFragment : Fragment() {

    private var textView: TextView? = null
    private var switchCompat: SwitchCompat? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        switchCompat = view?.findViewById(R.id.switcher)
        textView = view?.findViewById(R.id.text_view)
    }

    private fun initListeners() {
        switchCompat?.setOnCheckedChangeListener { _, newValue ->
            viewModel.updateTo(newValue)
        }
    }

    private fun initObservers() {
        viewModel.activated.observe(viewLifecycleOwner, Observer {
            switchCompat?.isChecked = it
            @StringRes val stringRes = if (it) {
                R.string.mesure_enable
            } else {
                R.string.mesure_disable
            }
            textView?.setText(stringRes)
        })
    }

}

