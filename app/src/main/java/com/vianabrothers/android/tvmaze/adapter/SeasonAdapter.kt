package com.vianabrothers.android.tvmaze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vianabrothers.android.tvmaze.databinding.ItemSeasonBinding
import com.vianabrothers.android.tvmaze.model.Episode

class SeasonAdapter(
    private val episodeClick: EpisodeClickListener
) :
    ListAdapter<Episode, SeasonAdapter.SeasonViewHolder>(SeasonDiffCallback()) {

    var myCompleteList = emptyList<Episode>()

    class SeasonViewHolder(private val binding: ItemSeasonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: Episode, adapterEpisode: EpisodeAdapter) {
            binding.idSeason.text = episode.season.toString()
            binding.idSeasonEpisodeList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = adapterEpisode
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShow = ItemSeasonBinding.inflate(layoutInflater, parent, false)
        return SeasonViewHolder(itemShow)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val episode = getItem(position)
        val adapterEpisode : EpisodeAdapter = EpisodeAdapter(episodeClick, myCompleteList.filter{ temp -> temp.season == episode.season})
        episode?.let {
            holder.bind(it, adapterEpisode)
        }
    }

    fun submitMyList(seasonsList:List<Episode>, completeList:List<Episode>){
        myCompleteList = completeList
        submitList(seasonsList)
    }
}

private class SeasonDiffCallback : DiffUtil.ItemCallback<Episode>() {

    override fun areItemsTheSame(
        oldItem: Episode,
        newItem: Episode
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Episode,
        newItem: Episode
    ): Boolean {
        return oldItem == newItem
    }
}