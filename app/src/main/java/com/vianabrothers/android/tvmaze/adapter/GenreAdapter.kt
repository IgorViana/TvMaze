package com.vianabrothers.android.tvmaze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vianabrothers.android.tvmaze.databinding.ItemGenreBinding

class GenreAdapter : ListAdapter<String, GenreAdapter.GenreViewHolder>(GenreDiffCallback()) {

    class GenreViewHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genre: String) {
            binding.idGenreChip.text = genre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShow = ItemGenreBinding.inflate(layoutInflater, parent, false)
        return GenreViewHolder(itemShow)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = getItem(position)
        genre?.let {
            holder.bind(it)
        }
    }
}

private class GenreDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }
}