package com.ilmal08.kmptemplate.domain.entity.common

sealed interface ErrorEntity {

    companion object {
        fun networkConnection() = NetworkConnection
        fun apiError(
            errorMessage: String? = "",
            responseCode: Int? = null,
            exception: Exception? = null
        ) = ErrorEntity.ApiError(errorMessage, responseCode, exception)

        fun unexpected(exception: Throwable) = Unexpected(exception)
    }

    object NetworkConnection : ErrorEntity

    data class ApiError(
        val errorMessage: String? = "",
        val responseCode: Int? = null,
        val exception: Exception? = null
    ) : ErrorEntity

    data class Unexpected(val e: Throwable) : ErrorEntity

    abstract class FeatureError : ErrorEntity
}