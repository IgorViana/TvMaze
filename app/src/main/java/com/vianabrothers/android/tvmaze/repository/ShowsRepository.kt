package com.vianabrothers.android.tvmaze.repository

import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.network.services.TvMazeService

class ShowsRepository(
    private val tvMazeService: TvMazeService
): ShowsRepositoryInterface {

    override suspend fun getListShows(page: Int): List<Show> {
        return tvMazeService.getListShows(page)
    }

    override suspend fun searchShows(param: String): List<Show> {
        return tvMazeService.searchShows(param)
    }

}