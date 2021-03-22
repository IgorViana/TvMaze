package com.vianabrothers.android.tvmaze.repository

import com.vianabrothers.android.tvmaze.model.Episode
import com.vianabrothers.android.tvmaze.model.SearchShow
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.network.services.TvMazeService

class ShowsRepository(
    private val tvMazeService: TvMazeService
) : ShowsRepositoryInterface {

    override suspend fun getListShows(page: Int): List<Show> {
        return tvMazeService.getListShows(page)
    }

    override suspend fun searchShows(param: String): List<SearchShow> {
        return tvMazeService.searchShows(param)
    }

    override suspend fun getShowsEpisodes(showId: Long): List<Episode> {
        return tvMazeService.getShowEpisodes(showId)
    }

}