package com.ilmal08.kmptemplate.views.screen.home.viewmodel

import com.ilmal08.kmptemplate.domain.entity.movie.DetailMovie
import com.ilmal08.kmptemplate.domain.entity.movie.mapper.AllDetailMapper
import com.ilmal08.kmptemplate.domain.repository.MovieRepository
import com.ilmal08.kmptemplate.util.ViewModel
import com.ilmal08.kmptemplate.util.viewModelScope
import com.ilmal08.kmptemplate.views.state.DetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MovieRepository) : ViewModel {

    private val _uiState = MutableStateFlow(DetailState())
    val uiState: StateFlow<DetailState> = _uiState

    private val mapper = AllDetailMapper()

    fun fetchData(movieId: Int) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val movieDetailResult = repository.getDetail(movieId)
            val movieCreditResult = repository.getCredit(movieId)
            val similarResult = repository.getSimilar(movieId)

            if (movieDetailResult.isSuccess &&
                movieCreditResult.isSuccess &&
                similarResult.isSuccess) {
                _uiState.update { uiState ->
                    uiState.copy(
                        isLoading = false, detailMovie = mapper.map(
                            from = movieDetailResult.getOrDefault(DetailMovie()),
                            credit = movieCreditResult.getOrDefault(listOf()),
                            similar = similarResult.getOrDefault(listOf())
                        ),
                        error = null
                    )
                }
            } else {
                _uiState.update { uiState ->
                    uiState.copy(isLoading = false, error = "ERROR!")
                }
            }
        }
    }
}