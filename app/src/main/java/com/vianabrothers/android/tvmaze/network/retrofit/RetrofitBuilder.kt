package com.vianabrothers.android.tvmaze.network.retrofit

import com.vianabrothers.android.tvmaze.network.services.TvMazeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit {
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl("http://api.tvmaze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE as Retrofit
        }
    }

    var tvMazeService: TvMazeService = getInstance().create(
        TvMazeService::class.java
    )
}