package com.vianabrothers.android.tvmaze.repository

import com.vianabrothers.android.tvmaze.model.Episode
import com.vianabrothers.android.tvmaze.model.SearchShow
import com.vianabrothers.android.tvmaze.model.Show

interface ShowsRepositoryInterface {

    suspend fun getListShows(page: Int): List<Show>

    suspend fun searchShows(param: String): List<SearchShow>

    suspend fun getShowsEpisodes(showId: Long): List<Episode>
}