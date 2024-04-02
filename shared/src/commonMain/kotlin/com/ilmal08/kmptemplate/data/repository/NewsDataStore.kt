package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.model.payload.NewsPayload
import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.data.model.BaseResponse
import com.ilmal08.kmptemplate.util.Constant
import com.ilmal08.kmptemplate.util.Constant.API
import com.ilmal08.kmptemplate.util.Constant.BASE_URL
import com.ilmal08.kmptemplate.data.model.WrapResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class NewsApi : NewsRepository {
    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = false
                coerceInputValues = true
                explicitNulls = true
            })
        }

        install(HttpTimeout) {
            connectTimeoutMillis = Constant.TIMEOUT
            requestTimeoutMillis = Constant.TIMEOUT
            socketTimeoutMillis = Constant.TIMEOUT
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    co.touchlab.kermit.Logger.d { message }
                }
            }
            level = LogLevel.ALL
        }
    }

    override suspend fun getNews(): BaseResponse<NewsResponse> {
        val responseData = client.get("$BASE_URL/svc/topstories/v2/home.json") {
            contentType(Json)
            setBody(
                NewsPayload(apiKey = API)
            )
        }

        val resp = responseData.body<WrapResponse<NewsResponse>>()
        return when (responseData.status.value) {
            in 200..299 -> {
                BaseResponse.Success(resp.result)
            }
            else -> {
                BaseResponse.Error(Exception(resp.message))
            }
        }
    }
}