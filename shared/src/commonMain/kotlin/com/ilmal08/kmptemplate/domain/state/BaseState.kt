package com.ilmal08.kmptemplate.domain.state

import com.ilmal08.kmptemplate.domain.entity.common.ErrorEntity

sealed class BaseState<out T> {

    object StateInitial : BaseState<Nothing>()

    data class StateSuccess<out T>(val data: T?) : BaseState<T>()

    data class StateFailed(
        val error: ErrorEntity, val generalError: Boolean = false
    ) : BaseState<Nothing>()

    object StateLoading : BaseState<Nothing>()

    fun data() = if (this is StateSuccess) data else null

    fun apiError() = if (this is StateFailed) ErrorEntity.ApiError() else null
}