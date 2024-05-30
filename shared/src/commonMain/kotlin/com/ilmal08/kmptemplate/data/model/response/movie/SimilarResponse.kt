package com.ilmal08.kmptemplate.data.model.response.movie

import com.ilmal08.kmptemplate.domain.entity.movie.SimilarMovie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimilarResponse(
    @SerialName("page") val page: Long,
    @SerialName("results") val results: List<Result>,
    @SerialName("total_pages") val totalPages: Long,
    @SerialName("total_results") val totalResults: Long
) {
    @Serializable
    data class Result(
        @SerialName("adult") val adult: Boolean,
        @SerialName("backdrop_path") val backdropPath: String? = null,
        @SerialName("genre_ids") val genreIDS: List<Long>,
        @SerialName("id") val id: Long,
        @SerialName("original_language") val originalLanguage: String,
        @SerialName("original_title") val originalTitle: String,
        @SerialName("overview") val overview: String,
        @SerialName("popularity") val popularity: Double,
        @SerialName("poster_path") val posterPath: String,
        @SerialName("release_date") val releaseDate: String,
        @SerialName("title") val title: String,
        @SerialName("video") val video: Boolean,
        @SerialName("vote_average") val voteAverage: Double,
        @SerialName("vote_count") val voteCount: Long
    ) {
        fun toDomain() = SimilarMovie(
            movieId = id.toInt(),
            title = title,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage
        )
    }
}