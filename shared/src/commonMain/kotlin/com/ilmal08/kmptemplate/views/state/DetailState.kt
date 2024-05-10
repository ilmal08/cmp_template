package com.ilmal08.kmptemplate.views.state

import com.ilmal08.kmptemplate.domain.entity.movie.AllDetailMovie

data class DetailState(
    val isLoading: Boolean = true,
    val detailMovie: AllDetailMovie = AllDetailMovie(),
    val error: String? = null
)