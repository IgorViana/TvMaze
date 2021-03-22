package com.vianabrothers.android.tvmaze.ui.episodeDetailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.vianabrothers.android.tvmaze.databinding.EpisodeDetailFragmentBinding
import com.vianabrothers.android.tvmaze.model.Episode
import com.vianabrothers.android.tvmaze.utils.HtmlParse
import com.vianabrothers.android.tvmaze.utils.downloadImage
import org.koin.android.viewmodel.ext.android.viewModel

class EpisodeDetailFragment : Fragment() {

    private lateinit var binding: EpisodeDetailFragmentBinding
    private lateinit var episode: Episode

    private val viewModel: EpisodeDetailViewModel by viewModel()
    private val args: EpisodeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EpisodeDetailFragmentBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {
        episode = args.episode
        populateEpisode()
    }

    private fun populateEpisode() {
        binding.idEpsodeDetailImage.downloadImage(episode.image.original)
        binding.idEpsodeDetailName.text = episode.name
        binding.idEpsodeDetailNumber.text = episode.number.toString()
        binding.idEpsodeDetailSeason.text = episode.season.toString()
        binding.idEpsodeDetailSummary.text = HtmlParse().parseHtml(episode.summary)
    }

}