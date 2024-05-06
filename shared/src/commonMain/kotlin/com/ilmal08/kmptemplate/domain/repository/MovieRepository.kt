package com.ilmal08.kmptemplate.domain.repository

import com.ilmal08.kmptemplate.domain.entity.movie.NowPlayingMovie
import com.ilmal08.kmptemplate.domain.entity.movie.PopularMovie

interface MovieRepository {
    suspend fun getPopularMovie(): Result<List<PopularMovie>>
    suspend fun getNowPlaying(): Result<List<NowPlayingMovie>>
}