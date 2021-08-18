package br.com.movies.viewmodel

import androidx.lifecycle.ViewModel
import br.com.movies.model.Movie
import br.com.movies.model.SimilarMovie
import br.com.movies.repository.MovieRepository
import retrofit2.Callback

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovie(callback: Callback<Movie>) = movieRepository.getMovie(callback = callback)

    fun getSimilarMovie(callback: Callback<SimilarMovie>) = movieRepository.getSimilarMovie(callback = callback)

}
