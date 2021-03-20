package com.vianabrothers.android.tvmaze.repository

import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.network.services.TvMazeService

class ShowsRepository(
    private val tvMazeService: TvMazeService
) {
    suspend fun getListShows(page: Int): List<Show> {
        return tvMazeService.getListShows(page)
    }
}