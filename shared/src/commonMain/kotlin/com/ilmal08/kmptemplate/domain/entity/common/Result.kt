package com.ilmal08.kmptemplate.domain.entity.common

sealed interface Result<out T> {

    data class Success<T>(val data: T) : Result<T>

    data class Error(val errorEntity: ErrorEntity? = null) : Result<Nothing>

    companion object {
        val EMPTY = Success(Unit)

        fun <T> success(data: T): Result<T> = Success(data)
        fun error(errorEntity: ErrorEntity? = null): Error = Error(errorEntity)
    }
}

inline fun <T : Any?> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)
    return this
}

inline fun <T : Any?> Result<T>.onError(action: (errorEntity: ErrorEntity?) -> Unit): Result<T> {
    if (this is Result.Error) action(errorEntity)
    return this
}

inline fun <T : Any?, R> Result<T>.mapDataOnSuccess(transform: (T) -> R): Result<R> {
    return when (this) {
        is Result.Error -> this
        is Result.Success -> Result.success(transform(data))
    }
}