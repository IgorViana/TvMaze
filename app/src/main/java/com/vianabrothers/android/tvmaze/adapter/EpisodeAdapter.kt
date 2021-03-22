package com.vianabrothers.android.tvmaze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vianabrothers.android.tvmaze.databinding.ItemEpisodeBinding
import com.vianabrothers.android.tvmaze.model.Episode

class EpisodeAdapter(
    private val clickListener: EpisodeClickListener,
    private val listEpisodes: List<Episode>
) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: Episode, clickListener: EpisodeClickListener) {
            binding.idItemEpsodeNumber.text = episode.number.toString()
            binding.idItemEpsodeName.text = episode.name
            binding.root.setOnClickListener {
                clickListener.onEpisodeClick(episode)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShow = ItemEpisodeBinding.inflate(layoutInflater, parent, false)
        return EpisodeViewHolder(itemShow)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = listEpisodes[position]
        holder.bind(episode, clickListener)
    }

    override fun getItemCount(): Int {
        return listEpisodes.count()
    }
}

class EpisodeClickListener(val click: (episode: Episode) -> Unit) {
    fun onEpisodeClick(episode: Episode) {
        click(episode)
    }
}