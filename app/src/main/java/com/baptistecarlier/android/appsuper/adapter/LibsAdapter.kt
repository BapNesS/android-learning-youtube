package com.baptistecarlier.android.appsuper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baptistecarlier.android.appsuper.adapter.LibsAdapter.LibraryViewHolder
import com.baptistecarlier.android.appsuper.databinding.ItemLibraryBinding
import com.baptistecarlier.android.appsuper.domain.model.Library

class LibsAdapter(
    private val libs: List<Library>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<LibraryViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(library: Library)
    }

    override fun getItemCount() = libs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val vb = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LibraryViewHolder(vb, itemClickListener)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val library = libs[position]
        holder.bind(library)
    }

    class LibraryViewHolder(
        private val itemLibraryBinding: ItemLibraryBinding,
        private val itemClickListener: ItemClickListener
    ) :
        RecyclerView.ViewHolder(itemLibraryBinding.root) {

        fun bind(library: Library) {
            with(itemLibraryBinding) {
                title.text = library.title
                root.setOnClickListener {
                    itemClickListener.onItemClick(library)
                }
            }
        }

    }

}