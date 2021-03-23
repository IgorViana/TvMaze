package com.vianabrothers.android.tvmaze.ui.showDetailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vianabrothers.android.tvmaze.adapter.EpisodeAdapter
import com.vianabrothers.android.tvmaze.adapter.EpisodeClickListener
import com.vianabrothers.android.tvmaze.adapter.GenreAdapter
import com.vianabrothers.android.tvmaze.adapter.SeasonAdapter
import com.vianabrothers.android.tvmaze.databinding.ShowDetailsFragmentBinding
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.utils.HtmlParse
import com.vianabrothers.android.tvmaze.utils.downloadImage
import org.koin.android.viewmodel.ext.android.viewModel

class ShowDetailsFragment : Fragment() {

    private lateinit var binding: ShowDetailsFragmentBinding
    private lateinit var show: Show
    private lateinit var genreAdapter: GenreAdapter
    private lateinit var episodeAdapter: EpisodeAdapter
    private lateinit var seasonAdapter: SeasonAdapter

    private val viewModel: ShowDetailsViewModel by viewModel()
    private val args: ShowDetailsFragmentArgs by navArgs()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShowDetailsFragmentBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {
        show = args.show
        populateShow()
    }

    private fun populateShow() {
        binding.idDetailCover.downloadImage(show.image?.original)
        binding.idDetailTitle.text = show.name
        binding.idDetailTime.text = show.schedule.time
        binding.idDetailDays.text = concatenateDaysOfWeek()
        binding.idDetailSummary.text = HtmlParse().parseHtml(show.summary)
        setUpGenreList(show.genres)
        setUpEpisodesList()
    }

    private fun setUpGenreList(genres: List<String>) {
        genreAdapter = GenreAdapter()
        genreAdapter.submitList(genres)
        binding.IdDetailGenresList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = genreAdapter
        }
    }

    private fun setUpEpisodesList() {
        seasonAdapter = SeasonAdapter(EpisodeClickListener {
            val action =
                ShowDetailsFragmentDirections.actionDetailsFragmentToEpisodeDetailFragment(it)
            navController.navigate(action)
        })
        binding.idDetailEpisodes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = seasonAdapter
        }

        viewModel.getShowEpisodes(show.id)
        viewModel.showEpisodes.observe(viewLifecycleOwner, { list ->
            val temp = list.distinctBy { it.season }
            seasonAdapter.submitMyList(temp, list)
        })
    }

    private fun concatenateDaysOfWeek(): String {
        val builder = StringBuilder()
        show.schedule.days.forEach {
            builder.append(it)
            builder.append(" | ")
        }
        return builder.toString()
    }

}