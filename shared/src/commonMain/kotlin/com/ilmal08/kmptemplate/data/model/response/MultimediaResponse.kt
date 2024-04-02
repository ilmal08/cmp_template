package com.ilmal08.kmptemplate.data.model.response

import com.ilmal08.kmptemplate.entity.MultimediaEntity
import com.ilmal08.kmptemplate.entity.NewsEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultimediaResponse(
    @SerialName("caption")
    val caption: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("format")
    val format: String,
    @SerialName("height")
    val height: Int,
    @SerialName("subtype")
    val subtype: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String,
    @SerialName("width")
    val width: Int
) {
    fun mapToEntity() = MultimediaEntity(
       caption = caption,
        copyright = copyright,
        format = format,
        height = height,
        subtype = subtype,
        type = type,
        url = url,
        width = width
    )
}