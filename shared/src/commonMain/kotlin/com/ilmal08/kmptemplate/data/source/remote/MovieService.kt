package com.ilmal08.kmptemplate.data.source.remote

import com.ilmal08.kmptemplate.data.model.response.movie.NowPlayingResponse
import com.ilmal08.kmptemplate.data.model.response.movie.PopularMovieResponse

interface MovieService {
    suspend fun popularMovie(): PopularMovieResponse
    suspend fun nowPlaying(): NowPlayingResponse
}