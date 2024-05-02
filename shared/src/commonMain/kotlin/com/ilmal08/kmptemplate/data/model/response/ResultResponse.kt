package com.ilmal08.kmptemplate.data.model.response

import com.ilmal08.kmptemplate.domain.entity.ResultEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    @SerialName("abstract")
    val `abstract`: String,
    @SerialName("byline")
    val byline: String,
    @SerialName("created_date")
    val createdDate: String,
    @SerialName("des_facet")
    val desFacet: List<String>,
    @SerialName("geo_facet")
    val geoFacet: List<String>,
    @SerialName("item_type")
    val itemType: String,
    @SerialName("kicker")
    val kicker: String,
    @SerialName("material_type_facet")
    val materialTypeFacet: String,
    @SerialName("multimedia")
    val multimediaResponse: List<MultimediaResponse>?,
    @SerialName("org_facet")
    val orgFacet: List<String>,
    @SerialName("per_facet")
    val perFacet: List<String>,
    @SerialName("published_date")
    val publishedDate: String,
    @SerialName("section")
    val section: String,
    @SerialName("short_url")
    val shortUrl: String?,
    @SerialName("subsection")
    val subsection: String?,
    @SerialName("title")
    val title: String,
    @SerialName("updated_date")
    val updatedDate: String,
    @SerialName("uri")
    val uri: String,
    @SerialName("url")
    val url: String
) {
    fun mapToEntity() = ResultEntity(
        abstract = abstract,
        byline = byline,
        createdDate = createdDate,
        desFacet = desFacet,
        geoFacet = geoFacet,
        itemType = itemType,
        kicker = kicker,
        materialTypeFacet = materialTypeFacet,
        multimediaResponse = multimediaResponse?.map { it.mapToEntity() },
        orgFacet = orgFacet,
        perFacet = perFacet,
        publishedDate = publishedDate,
        section = section,
        shortUrl = shortUrl,
        subsection = subsection,
        title = title,
        updatedDate = updatedDate,
        uri = uri,
        url = url
    )
}