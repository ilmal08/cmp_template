package com.ilmal08.kmptemplate.util

import com.ilmal08.kmptemplate.data.model.ApiResponse

suspend fun <T> safeApiCall(apiCall: suspend () -> T): ApiResponse<T> {
    return try {
        val response = apiCall.invoke()
        logger.i("Success on get api data")
        ApiResponse.Success(response)
    } catch (e: Exception) {
        logger.e("Error on get api data", e)
        ApiResponse.Error(e.toString())
    }
}