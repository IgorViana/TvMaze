package com.vianabrothers.android.tvmaze.network.services

import com.vianabrothers.android.tvmaze.model.Show
import retrofit2.http.GET
import retrofit2.http.Query

interface TvMazeService {
    @GET("shows")
    suspend fun getListShows(@Query("page") page: Int): List<Show>
}