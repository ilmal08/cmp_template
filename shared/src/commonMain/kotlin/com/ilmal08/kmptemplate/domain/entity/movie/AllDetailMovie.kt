package com.ilmal08.kmptemplate.domain.entity.movie

data class AllDetailMovie(
    val movieId: Int = 0,
    val runtime: Int = 0,
    val releaseDate: String = "",
    val voteAverage: Double = 0.0,
    val title: String = "",
    val overview: String = "",
    val posterPath: String = "",
    val genre: String = "",
    val voteCount: Int = 0,
    val backdropPath: String = "",
    val credit: List<CreditMovie> = listOf(),
    val homepage: String = ""
)