package com.ilmal08.kmptemplate.data.source.remote.impl

import com.ilmal08.kmptemplate.data.model.response.movie.CreditMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.DetailMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.NowPlayingResponse
import com.ilmal08.kmptemplate.data.model.response.movie.PopularMovieResponse
import com.ilmal08.kmptemplate.data.source.remote.MovieService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MovieServiceImpl(
    private val client: HttpClient,
) : MovieService {
    override suspend fun popularMovie(): PopularMovieResponse {
        return client.get(POPULAR_MOVIE).body()
    }

    override suspend fun nowPlaying(): NowPlayingResponse {
        return client.get(NOW_PLAYING_MOVIE).body()
    }

    override suspend fun detail(id: Int): DetailMovieResponse {
        return client.get("movie/$id").body()
    }

    override suspend fun credit(id: Int): CreditMovieResponse {
        return client.get("movie/$id/credits").body()
    }


    companion object {
        const val POPULAR_MOVIE = "movie/popular"
        const val NOW_PLAYING_MOVIE = "movie/now_playing"
    }
}