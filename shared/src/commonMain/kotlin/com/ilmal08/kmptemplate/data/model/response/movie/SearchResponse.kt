package com.ilmal08.kmptemplate.data.model.response.movie

import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovie
import com.ilmal08.kmptemplate.util.Constant.DefaultValue.EMPTY_STRINGS
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("page") val page: Long,
    @SerialName("results") val results: List<Result>,
    @SerialName("total_pages") val totalPages: Long,
    @SerialName("total_results") val totalResults: Long
) {
    @Serializable
    data class Result(
        @SerialName("adult") val adult: Boolean,
        @SerialName("backdrop_path") val backdropPath: String? = null,
        @SerialName("genre_ids") val genreIDS: List<Long> = emptyList(),
        @SerialName("id") val id: Long = 0,
        @SerialName("original_language") val originalLanguage: String = EMPTY_STRINGS,
        @SerialName("original_title") val originalTitle: String = EMPTY_STRINGS,
        @SerialName("overview") val overview: String = EMPTY_STRINGS,
        @SerialName("popularity") val popularity: Double,
        @SerialName("poster_path") val posterPath: String = EMPTY_STRINGS,
        @SerialName("release_date") val releaseDate: String = EMPTY_STRINGS,
        @SerialName("title") val title: String = EMPTY_STRINGS,
        @SerialName("video") val video: Boolean = true,
        @SerialName("vote_average") val voteAverage: Double = 0.0,
        @SerialName("vote_count") val voteCount: Long = 0
    ) {
        fun toDomain() = SearchMovie(
            movieId = id.toInt(),
            title = title,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage
        )
    }
}