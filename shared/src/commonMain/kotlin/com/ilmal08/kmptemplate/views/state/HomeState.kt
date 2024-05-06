package com.ilmal08.kmptemplate.views.state

import com.ilmal08.kmptemplate.domain.entity.movie.NowPlayingMovie
import com.ilmal08.kmptemplate.domain.entity.movie.PopularMovie

data class HomeState(
    val isLoading: Boolean = true,
    val popularMovieData: List<PopularMovie> = emptyList(),
    val nowPlayingMovieData: List<NowPlayingMovie> = emptyList(),
    val error: String? = null
)