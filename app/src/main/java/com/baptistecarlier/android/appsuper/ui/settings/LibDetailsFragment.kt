package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.databinding.FragmentLibDetailsBinding
import com.baptistecarlier.android.appsuper.repository.libs

class LibDetailsFragment : Fragment() {

    private var _binding: FragmentLibDetailsBinding? = null
    // onCreate jusqu'au onDestroyView
    private val binding get() = _binding!!

    private val position: Int?
        get() = arguments?.let { LibDetailsFragmentArgs.fromBundle(it).position }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDatas()
    }

    private fun initDatas() {
        position?.let { position ->
            libs[position].let {
                binding.title.text = it.title
                binding.author.text = it.author
                binding.licence.text = it.licence
            }
        }
    }

}