package br.com.movies.model

data class SimilarMovie (
    val results: List<Similar>
)

data class Similar (
    val id: Int,
    val title: String,
    val backdrop_path: String,
    val release_date: String
)
