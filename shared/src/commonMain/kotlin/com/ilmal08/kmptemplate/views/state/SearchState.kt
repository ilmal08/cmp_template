package com.ilmal08.kmptemplate.views.state

import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovieMap

data class SearchState(
    val isLoading: Boolean = false,
    val data: List<SearchMovieMap> = listOf(),
    val error: String? = null,
    val emptyState: Boolean = false,
) {
    fun removeList() = copy(
        data = listOf(),
        isLoading = false,
        error = null,
        emptyState = false
    )

    fun updateData(list: List<SearchMovieMap>) = copy(
        data = list,
        isLoading = false,
        emptyState = list.isEmpty(),
    )

    fun showLoading() = copy(
        isLoading = true,
        error = null
    )

    fun showError(message: String) = copy(
        isLoading = false,
        data = listOf(),
        error = message
    )
}