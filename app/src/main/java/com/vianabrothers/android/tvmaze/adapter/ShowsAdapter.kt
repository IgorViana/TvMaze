package com.vianabrothers.android.tvmaze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vianabrothers.android.tvmaze.databinding.ItemShowBinding
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.utils.downloadImage

class ShowsAdapter :
    ListAdapter<Show, ShowsAdapter.ShowsViewHolder>(ShowsDiffCallback()) {

    class ShowsViewHolder(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(show: Show) {
            binding.idShowTitle.text = show.name
            binding.idShowCover.downloadImage(show)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShow = ItemShowBinding.inflate(layoutInflater, parent, false)
        return ShowsViewHolder(itemShow)
    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        val show = getItem(position)
        holder.bind(show)
    }

}

private class ShowsDiffCallback : DiffUtil.ItemCallback<Show>() {

    override fun areItemsTheSame(
        oldItem: Show,
        newItem: Show
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Show,
        newItem: Show
    ): Boolean {
        return oldItem == newItem
    }
}