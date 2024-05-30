package com.ilmal08.kmptemplate.domain.entity.movie

import com.ilmal08.kmptemplate.util.Constant.DefaultValue.EMPTY_STRINGS

class SearchMovieMap(
    val movieId: Int = 0,
    val releaseDate: String = EMPTY_STRINGS,
    val voteAverage: Double = 0.0,
    val title: String = EMPTY_STRINGS,
    val posterPath: String = EMPTY_STRINGS
)