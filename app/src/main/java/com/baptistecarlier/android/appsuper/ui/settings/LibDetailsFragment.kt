package com.baptistecarlier.android.appsuper.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.baptistecarlier.android.appsuper.R
import com.baptistecarlier.android.appsuper.repository.libs

class LibDetailsFragment : Fragment() {

    private var title: TextView? = null
    private var author: TextView? = null
    private var licence: TextView? = null

    private val position: Int?
        get() = arguments?.let { LibDetailsFragmentArgs.fromBundle(it).position }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_lib_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        title = view?.findViewById(R.id.title)
        author = view?.findViewById(R.id.author)
        licence = view?.findViewById(R.id.licence)
        initDatas()
    }

    private fun initDatas() {
        position?.let { position ->
            libs[position].let {
                title?.text = it.title
                author?.text = it.author
                licence?.text = it.licence
            }
        }
    }

}