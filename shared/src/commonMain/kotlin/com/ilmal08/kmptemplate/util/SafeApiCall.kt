package com.ilmal08.kmptemplate.util

import com.ilmal08.kmptemplate.data.model.WrapResponse

//suspend fun <T> safeApiCall(apiCall: suspend () -> T): WrapResponse<T> {
//    return try {
//        val response = apiCall.invoke()
//        co.touchlab.kermit.Logger.i("Success on get api data")
//        WrapResponse.Success(response)
//    } catch (e: Exception) {
//        co.touchlab.kermit.Logger.e("Error on get api data", e)
//        ApiResponse.Error(e.toString())
//    }
//}