package com.vianabrothers.android.tvmaze.network.services

import com.vianabrothers.android.tvmaze.model.Show
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvMazeService {

    @GET("shows")
    suspend fun getListShows(@Query("page") page: Int): List<Show>

    @GET("search/shows")
    suspend fun searchShows(@Query("q") param: String): List<Show>

    //TODO change the return to Episodes
    @GET("shows/{id}/episodes")
    suspend fun getShowEpisodes(@Path("id") id: Long): List<Show>

    @GET("shows/{id}/episodebynumber?season={season}&number={number}")
    suspend fun getEpisodeDetails(
        @Path("id") id: Long,
        @Path("season") season: Long,
        @Path("number") number: Long
    ): List<Show>

}