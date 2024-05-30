package com.ilmal08.kmptemplate.views.screen.home.viewmodel

import com.ilmal08.kmptemplate.domain.entity.movie.mapper.SearchMapper
import com.ilmal08.kmptemplate.domain.repository.MovieRepository
import com.ilmal08.kmptemplate.util.ViewModel
import com.ilmal08.kmptemplate.util.viewModelScope
import com.ilmal08.kmptemplate.views.state.SearchState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: MovieRepository
) : ViewModel {

    private val _uiState = MutableStateFlow(SearchState())
    val uiState: StateFlow<SearchState> = _uiState

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()


    private val mapper = SearchMapper()

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    fun makeSearch() {
        viewModelScope.launch {
            _query
                .debounce(500)
                .filter { str ->
                    if (str.isEmpty() || str.length < 3) {
                        _uiState.update {
                            it.removeList()
                        }
                        return@filter false
                    } else {
                        return@filter true
                    }
                }.mapLatest { str ->
                    _uiState.update {
                        it.showLoading()
                    }
                    repository.searchMovie(str)
                }.catch { err ->
                    _uiState.update {
                        it.showError(err.message ?: "Something went wrong")
                    }
                }.collect { result ->
                    result.onSuccess { list ->
                        _uiState.update { uiState ->
                            uiState.updateData(list = list.map { mapper.map(it) })
                        }
                    }
                }
        }
    }

    fun handleQueryChange(newQuery: String) {
        _query.value = newQuery
    }
}