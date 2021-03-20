package com.vianabrothers.android.tvmaze.application

import android.app.Application
import com.vianabrothers.android.tvmaze.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TvMazeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TvMazeApplication)
            koin.loadModules(listOf(appModule))
            koin.createRootScope()
        }
    }
}