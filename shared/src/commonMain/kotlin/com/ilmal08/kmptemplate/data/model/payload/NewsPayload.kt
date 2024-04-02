package com.ilmal08.kmptemplate.data.model.payload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsPayload(
    @SerialName("api-key") val apiKey: String,
)