package com.ilmal08.kmptemplate.domain

import com.ilmal08.kmptemplate.domain.entity.common.ErrorEntity
import com.ilmal08.kmptemplate.domain.entity.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.cancellation.CancellationException

class DispatcherHandler(val scope: CoroutineContext = Dispatchers.IO) {

    companion object {
        val IO by lazy { DispatcherHandler(Dispatchers.IO) }
    }

    suspend fun <T> execute(
        func: suspend () -> Result<T>
    ): Result<T> = withContext(scope) {
        try {
            func.invoke()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            else Result.error(ErrorEntity.unexpected(e))
        }
    }
}