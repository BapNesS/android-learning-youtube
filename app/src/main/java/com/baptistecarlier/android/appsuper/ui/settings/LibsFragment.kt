package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.databinding.FragmentLibsBinding
import com.baptistecarlier.android.appsuper.repository.libs

class LibsFragment : Fragment() {

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
        binding.lib0.let { button ->
            val position = 0
            initButton(button, position)
        }
        binding.lib1.let { button ->
            val position = 1
            initButton(button, position)
        }
        binding.lib2.let { button ->
            val position = 2
            initButton(button, position)
        }
        binding.lib3.let { button ->
            val position = 3
            initButton(button, position)
        }
        binding.lib4.let { button ->
            val position = 4
            initButton(button, position)
        }
    }

    private fun initButton(button: Button, position: Int) {
        button.text = libs[position].title
        button.setOnClickListener {
            val direction = LibsFragmentDirections.actionLibsFragmentToLibDetailsFragment(
                position = position
            )
            findNavController().navigate(direction)
        }
    }

}
