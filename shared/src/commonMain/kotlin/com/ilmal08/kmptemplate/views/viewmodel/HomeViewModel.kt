package com.ilmal08.kmptemplate.views.viewmodel

import cafe.adriel.voyager.core.model.StateScreenModel
import com.ilmal08.kmptemplate.data.model.ApiResponse
import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.repository.HomeRepository
import com.ilmal08.kmptemplate.views.state.BaseState
import com.ilmal08.kmptemplate.views.state.BaseState.Default
import com.ilmal08.kmptemplate.views.state.BaseState.Error
import com.ilmal08.kmptemplate.views.state.BaseState.Init
import com.ilmal08.kmptemplate.views.state.BaseState.Loading
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val repository: HomeRepository
) : StateScreenModel<BaseState>(Init) {

    private val _data = MutableStateFlow<NewsResponse?>(null)
    val data = _data.asStateFlow()

    suspend fun getNews() {
        mutableState.value = Loading

        repository.getNews().collect { result ->
            when (result) {
                is ApiResponse.Success -> {
                    _data.value = result.data
                    mutableState.value = Default
                }

                is ApiResponse.Error -> mutableState.value = Error
            }
        }
    }
}