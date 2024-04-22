package com.ilmal08.kmptemplate.repository

import com.ilmal08.kmptemplate.data.model.ApiResponse
import com.ilmal08.kmptemplate.data.model.WrapResponse
import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getNews(): Flow<ApiResponse<NewsResponse>>
}