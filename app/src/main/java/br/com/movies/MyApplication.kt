package br.com.movies

import android.app.Application
import br.com.movies.di.MovieModules
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(MovieModules.appModule))
    }
}