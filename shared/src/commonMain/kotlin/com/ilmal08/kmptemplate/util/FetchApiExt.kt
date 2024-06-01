package com.ilmal08.kmptemplate.util

import com.ilmal08.kmptemplate.data.model.response.otherResponse.ErrorResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val message: String) : ApiResult<Nothing>()
}

suspend inline fun <reified T> runBlockingWithResult(
    client: HttpClient,
    crossinline block: suspend HttpClient.() -> HttpResponse
): ApiResult<T> {
    return try {
        val response = client.block()
        val statusCode = response.status.value

        if (statusCode >= 400) {
            ApiResult.Error("HTTP Error: ${response.status}")
        } else {
            val responseData = response.body<T>()
            ApiResult.Success(responseData)
        }
    } catch (e: ClientRequestException) {
        val errorResponse = e.response.bodyAsText()
        val parsedError = Json.decodeFromString<ErrorResponse>(errorResponse)
        ApiResult.Error("${parsedError.statusMessage}")
    } catch (e: ServerResponseException) {
        val errorResponse = e.response.bodyAsText()
        val parsedError = Json.decodeFromString<ErrorResponse>(errorResponse)
        ApiResult.Error("${parsedError.statusMessage}")
    } catch (e: Exception) {
        ApiResult.Error("Exception: ${e.message}")
    }
}

inline fun <reified T> handleApiResult(result: ApiResult<T>): T {
    return when (result) {
        is ApiResult.Success -> {
            result.data
        }
        is ApiResult.Error -> {
            throw RuntimeException(result.message)
        }
    }
}