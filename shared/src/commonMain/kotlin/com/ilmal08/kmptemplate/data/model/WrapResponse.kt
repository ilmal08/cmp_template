package com.ilmal08.kmptemplate.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WrapResponse<T>(
    val code: Int,
    val message: String,
    val result: T? = null
)