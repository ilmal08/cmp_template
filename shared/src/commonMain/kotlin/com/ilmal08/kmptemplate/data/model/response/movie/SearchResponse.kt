package com.ilmal08.kmptemplate.data.model.response.movie

import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovie
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
        @SerialName("original_language") val originalLanguage: String? = null,
        @SerialName("original_title") val originalTitle: String? = null,
        @SerialName("overview") val overview: String? = null,
        @SerialName("popularity") val popularity: Double,
        @SerialName("poster_path") val posterPath: String? = null,
        @SerialName("release_date") val releaseDate: String? = null,
        @SerialName("title") val title: String? = null,
        @SerialName("video") val video: Boolean = true,
        @SerialName("vote_average") val voteAverage: Double = 0.0,
        @SerialName("vote_count") val voteCount: Long = 0
    ) {
        fun toDomain() = SearchMovie(
            movieId = id.toInt(),
            title = title.orEmpty(),
            posterPath = posterPath.orEmpty(),
            releaseDate = releaseDate.orEmpty(),
            voteAverage = voteAverage
        )
    }
}