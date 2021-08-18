package br.com.movies.di

import br.com.movies.repository.MovieRepository
import br.com.movies.utils.Retrofit
import br.com.movies.viewmodel.MovieViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object MovieModules {

    val appModule = module {

        single { Retrofit() }

        factory { MovieRepository( get() ) }

        viewModel { MovieViewModel( get() ) }

    }

}
