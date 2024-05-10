package com.ilmal08.kmptemplate.data.source.remote

import com.ilmal08.kmptemplate.data.model.response.movie.CreditMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.DetailMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.NowPlayingResponse
import com.ilmal08.kmptemplate.data.model.response.movie.PopularMovieResponse

interface MovieService {
    suspend fun popularMovie(): PopularMovieResponse
    suspend fun nowPlaying(): NowPlayingResponse

    suspend fun detail(id: Int): DetailMovieResponse

    suspend fun credit(id: Int): CreditMovieResponse
}