package com.ilmal08.kmptemplate.views.viewmodel

import com.ilmal08.kmptemplate.repository.MainRepository
import com.ilmal08.kmptemplate.views.state.NewsState
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BaseViewModel(private val repository: MainRepository) : ViewModel() {
    private val _newHome = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsHome: StateFlow<NewsState> = _newHome


    fun getHome() {
        viewModelScope.launch {
            _newHome.value = NewsState.Loading
            try {
                val response = repository.getHome()
                _newHome.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newHome.value = NewsState.Error(e.message.toString())
            }
        }
    }
}