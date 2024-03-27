package com.ilmal08.kmptemplate.views.state

import com.ilmal08.kmptemplate.data.response.NewsResponse

sealed class NewsState {
    object Loading : NewsState()
    data class Success(val news: NewsResponse): NewsState()
    data class Error(val error: String): NewsState()
}