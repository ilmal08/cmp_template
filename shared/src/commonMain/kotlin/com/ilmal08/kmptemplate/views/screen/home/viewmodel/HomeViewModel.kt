package com.ilmal08.kmptemplate.views.screen.home.viewmodel

import com.ilmal08.kmptemplate.domain.repository.MovieRepository
import com.ilmal08.kmptemplate.util.ViewModel
import com.ilmal08.kmptemplate.util.viewModelScope
import com.ilmal08.kmptemplate.views.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MovieRepository) : ViewModel {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            repository.getPopularMovie().onFailure { error ->
                _uiState.update { uiState ->
                    uiState.copy(
                        isLoading = false,
                        error = error.message ?: "Unknown error occurred"
                    )
                }
            }.onSuccess { popularMovies ->
                val nowPlayingMovieResult = repository.getNowPlaying()

                nowPlayingMovieResult.onSuccess { nowPlayingMovies ->
                    _uiState.update { uiState ->
                        uiState.copy(
                            isLoading = false,
                            popularMovieData = popularMovies,
                            nowPlayingMovieData = nowPlayingMovies
                        )
                    }
                }.onFailure { error ->
                    _uiState.update { uiState ->
                        uiState.copy(
                            isLoading = false,
                            error = error.message ?: "Unknown error occurred"
                        )
                    }
                }
            }
        }
    }
}