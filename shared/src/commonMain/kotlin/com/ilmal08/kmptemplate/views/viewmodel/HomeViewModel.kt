package com.ilmal08.kmptemplate.views.viewmodel

import com.ilmal08.kmptemplate.domain.entity.NewsEntity
import com.ilmal08.kmptemplate.domain.entity.common.onError
import com.ilmal08.kmptemplate.domain.entity.common.onSuccess
import com.ilmal08.kmptemplate.domain.repository.HomeDataRepository
import com.ilmal08.kmptemplate.util.CoroutineStateHandler
import com.ilmal08.kmptemplate.util.coroutineState
import com.ilmal08.kmptemplate.util.logger
import com.ilmal08.kmptemplate.domain.state.BaseState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val homeDataRepository: HomeDataRepository) : CoroutineStateHandler() {

    private val _dataState: MutableStateFlow<BaseState<NewsEntity?>> =
        MutableStateFlow(BaseState.StateInitial)

    val dataState = _dataState.asStateFlow()

    fun fetchNews() = coroutineState.launch {

        _dataState.value = BaseState.StateLoading

        homeDataRepository.getNews()
            .onSuccess {
                logger.i("BASE STATE SUCCESS = $_dataState")
                _dataState.value = BaseState.StateSuccess(it)
            }
            .onError { error ->
                error?.let {
                    _dataState.value = BaseState.StateFailed(it)
                }
                logger.i("BASE STATE ERROR = $_dataState")
            }
    }
}