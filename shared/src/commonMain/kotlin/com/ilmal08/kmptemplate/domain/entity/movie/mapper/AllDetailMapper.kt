package com.ilmal08.kmptemplate.domain.entity.movie.mapper

import com.ilmal08.kmptemplate.domain.entity.movie.AllDetailMovie
import com.ilmal08.kmptemplate.domain.entity.movie.CreditMovie
import com.ilmal08.kmptemplate.domain.entity.movie.DetailMovie
import com.ilmal08.kmptemplate.domain.entity.movie.SimilarMovie

class AllDetailMapper {
    fun map(
        from: DetailMovie,
        credit: List<CreditMovie>,
        similar: List<SimilarMovie>
        ): AllDetailMovie {
        with(from) {
            return AllDetailMovie(
                movieId = movieId,
                runtime = runtime,
                releaseDate = releaseDate,
                voteAverage = voteAverage,
                title = title,
                overview = overview,
                posterPath = posterPath,
                genre = genre,
                voteCount = voteCount,
                backdropPath = backdropPath,
                credit = credit,
                similar = similar
            )
        }
    }
}