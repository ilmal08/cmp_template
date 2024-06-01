package com.ilmal08.kmptemplate.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

suspend inline fun <T> invoke(noinline block: suspend () -> T): T = withContext(Dispatchers.IO) {
    block()
}

inline fun <R> getResult(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}