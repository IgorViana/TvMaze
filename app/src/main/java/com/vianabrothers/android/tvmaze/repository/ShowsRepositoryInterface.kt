package com.vianabrothers.android.tvmaze.repository

import com.vianabrothers.android.tvmaze.model.Show

interface ShowsRepositoryInterface {

    suspend fun getListShows(page: Int): List<Show>

    suspend fun searchShows(param: String): List<Show>
}