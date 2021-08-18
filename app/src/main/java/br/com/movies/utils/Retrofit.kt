package br.com.movies.utils

import br.com.movies.remote.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    fun movieApi(): MovieApi = retrofit.create(MovieApi::class.java)

}