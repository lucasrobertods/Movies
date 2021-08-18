package br.com.movies.remote

import br.com.movies.model.Movie
import br.com.movies.model.SimilarMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    companion object {
        const val apiAcessKey = "63ba5a932723f9a93a89fd95435bbdfd"
    }

    @GET("movie/{movie_id}?api_key=$apiAcessKey")
    fun getMovie(
        @Path("movie_id") movieId: String? = "550"
    ): Call<Movie>

    @GET("movie/{movie_id}/similar?api_key=$apiAcessKey")
    fun getSimilar(
        @Path("movie_id") movieId: String? = "550"
    ): Call<SimilarMovie>

}
