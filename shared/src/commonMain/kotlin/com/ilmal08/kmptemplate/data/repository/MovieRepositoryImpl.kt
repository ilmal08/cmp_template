package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.source.remote.MovieService
import com.ilmal08.kmptemplate.domain.entity.movie.NowPlayingMovie
import com.ilmal08.kmptemplate.domain.entity.movie.PopularMovie
import com.ilmal08.kmptemplate.domain.repository.MovieRepository
import com.ilmal08.kmptemplate.domain.resultOf

class MovieRepositoryImpl(
    private val service: MovieService,
//    private val sessionSettings: SessionSettings
) : MovieRepository {
    override suspend fun getPopularMovie(): Result<List<PopularMovie>> {
        return resultOf {
            service.popularMovie().movies.map { it.toDomain() }
        }
    }

    override suspend fun getNowPlaying(): Result<List<NowPlayingMovie>> {
        return resultOf {
            service.nowPlaying().movies.map { it.toDomain() }
        }
    }
}