package com.ilmal08.kmptemplate.data.remote

import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.util.Constant
import com.ilmal08.kmptemplate.util.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object NewsApi {
    suspend fun getHome(): NewsResponse {
        val url = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=${Constant.API}"
        return httpClient.get(url).body()
    }
}