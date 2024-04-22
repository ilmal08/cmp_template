package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.model.ApiResponse
import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.repository.HomeRepository
import com.ilmal08.kmptemplate.util.Constant
import com.ilmal08.kmptemplate.util.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HomeRepositoryImpl(
    private val httpClient: HttpClient
) : HomeRepository {
    override suspend fun getNews(): Flow<ApiResponse<NewsResponse>> {
        val apiCall = safeApiCall {
            val response = httpClient.get(
                "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=${Constant.API}"
            )
            response.body<NewsResponse>()
        }
        return flowOf(apiCall)
    }
}