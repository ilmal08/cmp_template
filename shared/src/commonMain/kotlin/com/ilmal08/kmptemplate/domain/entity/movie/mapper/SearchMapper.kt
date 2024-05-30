package com.ilmal08.kmptemplate.domain.entity.movie.mapper

import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovie
import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovieMap

class SearchMapper {
    fun map(from: SearchMovie): SearchMovieMap {
        with(from) {
            return SearchMovieMap(
                movieId = movieId,
                title = title,
                posterPath = posterPath,
                voteAverage = voteAverage,
                releaseDate = releaseDate
            )
        }
    }
}