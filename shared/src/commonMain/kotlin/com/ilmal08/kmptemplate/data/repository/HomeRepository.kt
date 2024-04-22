package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.model.WrapResponse
import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getNews(): Flow<WrapResponse<NewsResponse>>
}