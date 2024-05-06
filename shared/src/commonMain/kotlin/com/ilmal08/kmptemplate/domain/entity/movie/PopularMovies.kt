package com.ilmal08.kmptemplate.domain.entity.movie

data class PopularMovie(
    val movieId: Int,
    val releaseDate: String?,
    val voteAverage: Double?,
    val title: String,
    val posterPath: String?
)