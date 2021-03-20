package com.vianabrothers.android.tvmaze.network.retrofit

import com.vianabrothers.android.tvmaze.network.services.TvMazeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        private var INSTANCE: Retrofit? = null

        private fun getClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }

        fun getInstance(): Retrofit {
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl("https://api.tvmaze.com/")
                    .client(getClient())
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