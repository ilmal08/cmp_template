package com.ilmal08.kmptemplate.data.model.response

import com.ilmal08.kmptemplate.domain.entity.NewsEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("copyright")
    val copyright: String,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("num_results")
    val numResults: Int,
    @SerialName("results")
    val resultResponses: List<ResultResponse>,
    @SerialName("section")
    val section: String,
    @SerialName("status")
    val status: String
) {
    fun mapToEntity() = NewsEntity(
        copyright = copyright,
        lastUpdated = lastUpdated,
        numResults = numResults,
        resultResponses = resultResponses.map { it.mapToEntity() },
        section = section,
        status = status
    )
}