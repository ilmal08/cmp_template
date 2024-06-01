package com.ilmal08.kmptemplate.data.model.response.otherResponse

import com.ilmal08.kmptemplate.util.Constant.DefaultValue.EMPTY_STRINGS
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse (
    @SerialName("success") val success: Boolean? = true,
    @SerialName("status_code") val statusCode: Long? = 504,
    @SerialName("status_message") val statusMessage: String? = EMPTY_STRINGS
)