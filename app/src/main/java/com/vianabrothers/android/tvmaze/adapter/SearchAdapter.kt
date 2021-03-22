package com.vianabrothers.android.tvmaze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vianabrothers.android.tvmaze.databinding.ItemShowBinding
import com.vianabrothers.android.tvmaze.model.SearchShow
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.utils.downloadImage


class SearchAdapter(private val showClickListener: ShowClickListener) :
    ListAdapter<SearchShow, SearchAdapter.SearchViewHolder>(SearchDiffCallback()) {

    class SearchViewHolder(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(show: Show, showClickListener: ShowClickListener) {
            binding.idShowTitle.text = show.name
            binding.idShowCover.downloadImage(show.image?.original)
            binding.root.setOnClickListener {
                showClickListener.onShowClick(show)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShow = ItemShowBinding.inflate(layoutInflater, parent, false)
        return SearchViewHolder(itemShow)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val show = getItem(position)
        show?.let {
            holder.bind(it.show, showClickListener)
        }
    }
}

private class SearchDiffCallback : DiffUtil.ItemCallback<SearchShow>() {

    override fun areItemsTheSame(
        oldItem: SearchShow,
        newItem: SearchShow
    ): Boolean {
        return oldItem.show.id == newItem.show.id
    }

    override fun areContentsTheSame(
        oldItem: SearchShow,
        newItem: SearchShow
    ): Boolean {
        return oldItem == newItem
    }
}
