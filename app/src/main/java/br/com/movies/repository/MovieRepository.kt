package br.com.movies.repository

import br.com.movies.model.Movie
import br.com.movies.model.SimilarMovie
import br.com.movies.utils.Retrofit
import retrofit2.Callback

class MovieRepository(private val retrofit: Retrofit) {

    fun getMovie(callback: Callback<Movie>) {
        val movieApi = retrofit.movieApi()
        val call =  movieApi.getMovie()
        call.enqueue(callback)
    }

    fun getSimilarMovie(callback: Callback<SimilarMovie>) {
        val movieApi = retrofit.movieApi()
        val call =  movieApi.getSimilar()
        call.enqueue(callback)
    }

}
