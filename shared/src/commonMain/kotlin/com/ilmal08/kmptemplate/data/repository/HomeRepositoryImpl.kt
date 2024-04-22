package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.model.WrapResponse
import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(private val httpClient: HttpClient) : HomeRepository {
    override suspend fun getNews(): Flow<WrapResponse<NewsResponse>> {
        TODO("Not yet implemented")

    }
}