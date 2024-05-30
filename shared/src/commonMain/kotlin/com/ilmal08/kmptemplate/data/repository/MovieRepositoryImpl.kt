package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.source.remote.MovieService
import com.ilmal08.kmptemplate.domain.entity.movie.CreditMovie
import com.ilmal08.kmptemplate.domain.entity.movie.DetailMovie
import com.ilmal08.kmptemplate.domain.entity.movie.NowPlayingMovie
import com.ilmal08.kmptemplate.domain.entity.movie.PopularMovie
import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovie
import com.ilmal08.kmptemplate.domain.entity.movie.SimilarMovie
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

    override suspend fun getDetail(id: Int): Result<DetailMovie> {
        return resultOf {
            service.detail(id).toDomain()
        }
    }

    override suspend fun getCredit(id: Int): Result<List<CreditMovie>> {
        return resultOf {
            service.credit(id).cast.map { it.toDomain() }
        }
    }

    override suspend fun getSimilar(id: Int): Result<List<SimilarMovie>> {
        return resultOf {
            service.similarMovie(id).results.map { it.toDomain() }
        }
    }

    override suspend fun searchMovie(query: String): Result<List<SearchMovie>> {
        return resultOf {
            service.searchMovie(query).results.map { it.toDomain() }
        }
    }

}