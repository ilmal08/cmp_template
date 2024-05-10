package com.ilmal08.kmptemplate.views.screen.home.viewmodel

import com.ilmal08.kmptemplate.domain.entity.movie.DetailMovie
import com.ilmal08.kmptemplate.domain.entity.movie.mapper.AllDetailMapper
import com.ilmal08.kmptemplate.domain.repository.MovieRepository
import com.ilmal08.kmptemplate.util.ViewModel
import com.ilmal08.kmptemplate.util.viewModelScope
import com.ilmal08.kmptemplate.views.state.DetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MovieRepository) : ViewModel {

    private val _uiState = MutableStateFlow(DetailState())
    val uiState: StateFlow<DetailState> = _uiState

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> get() = _isFavorite

    private val _uiRating = MutableStateFlow<Int?>(null)
    private val _actualRating = MutableStateFlow<Int?>(null)
    val rating = _uiRating.asStateFlow()

    private val mapper = AllDetailMapper()

    fun fetchData(movieId: Int) {
        viewModelScope.launch {
            val movieDetailResult = repository.getDetail(movieId)
            val movieCreditResult = repository.getCredit(movieId)

            if (movieDetailResult.isSuccess && movieCreditResult.isSuccess) {
                _uiState.update { uiState ->
                    uiState.copy(
                        isLoading = false,
                        detailMovie = mapper.map(
                            from = movieDetailResult.getOrDefault(DetailMovie()),
                            credit = movieCreditResult.getOrDefault(listOf())
                        )
                    )
                }
            } else {
                _uiState.update { uiState ->
                    uiState.copy(isLoading = false, error = "Hata!")
                }
            }
        }
    }
}