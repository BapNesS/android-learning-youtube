package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.repository.libs

class LibsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_libs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        view?.findViewById<Button>(R.id.lib_0)?.let { button ->
            val position = 0
            initButton(button, position)
        }
        view?.findViewById<Button>(R.id.lib_1)?.let { button ->
            val position = 1
            initButton(button, position)
        }
        view?.findViewById<Button>(R.id.lib_2)?.let { button ->
            val position = 2
            initButton(button, position)
        }
        view?.findViewById<Button>(R.id.lib_3)?.let { button ->
            val position = 3
            initButton(button, position)
        }
        view?.findViewById<Button>(R.id.lib_4)?.let { button ->
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
