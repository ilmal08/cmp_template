package com.ilmal08.kmptemplate.repository

import com.ilmal08.kmptemplate.data.remote.NewsClientApi
import com.ilmal08.kmptemplate.data.response.NewsResponse

class MainRepository {
    suspend fun getHome() : NewsResponse {
        return NewsClientApi.getHome()
    }
}