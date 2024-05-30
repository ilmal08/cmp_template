package com.ilmal08.kmptemplate.domain.entity.movie

import com.ilmal08.kmptemplate.util.Constant.DefaultValue.EMPTY_STRINGS

data class SearchMovie(
    val movieId: Int,
    val releaseDate: String = EMPTY_STRINGS,
    val voteAverage: Double,
    val title: String = EMPTY_STRINGS,
    val posterPath: String = EMPTY_STRINGS
)
