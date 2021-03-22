package com.vianabrothers.android.tvmaze.di

import com.vianabrothers.android.tvmaze.network.retrofit.RetrofitBuilder
import com.vianabrothers.android.tvmaze.network.services.TvMazeService
import com.vianabrothers.android.tvmaze.repository.ShowsRepository
import com.vianabrothers.android.tvmaze.ui.showDetailsFragment.ShowDetailsViewModel
import com.vianabrothers.android.tvmaze.ui.mainFragment.MainFragmentViewModel
import com.vianabrothers.android.tvmaze.ui.searchFragment.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single<Retrofit> { RetrofitBuilder.getInstance() }
    single<TvMazeService> { RetrofitBuilder().tvMazeService }


    // single instance of HelloRepository
    factory<ShowsRepository> { ShowsRepository(get()) }

    // Simple Presenter Factory
    //factory { MySimplePresenter(get()) }

    viewModel { MainFragmentViewModel(get()) }
    viewModel { ShowDetailsViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}