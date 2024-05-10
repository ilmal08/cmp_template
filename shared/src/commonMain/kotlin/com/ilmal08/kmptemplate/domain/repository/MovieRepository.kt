package com.ilmal08.kmptemplate.domain.repository

import com.ilmal08.kmptemplate.domain.entity.movie.CreditMovie
import com.ilmal08.kmptemplate.domain.entity.movie.DetailMovie
import com.ilmal08.kmptemplate.domain.entity.movie.NowPlayingMovie
import com.ilmal08.kmptemplate.domain.entity.movie.PopularMovie

interface MovieRepository {
    suspend fun getPopularMovie(): Result<List<PopularMovie>>
    suspend fun getNowPlaying(): Result<List<NowPlayingMovie>>

    suspend fun getDetail(id: Int): Result<DetailMovie>

    suspend fun getCredit(id: Int): Result<List<CreditMovie>>
}