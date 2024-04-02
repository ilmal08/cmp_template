package com.ilmal08.kmptemplate.repository

import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.data.remote.NewsApi

class MainRepository {
    suspend fun getHome() : NewsResponse {
        return NewsApi.getHome()
    }
}