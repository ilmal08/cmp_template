package com.ilmal08.kmptemplate.util

object Constant {
    object DefaultValue {
        const val EMPTY_STRINGS = ""
    }

    object ApiConfig {
        const val BASE_URL_MOVIE = "https://api.themoviedb.org/3/"
        const val API_KEY_MOVIE = "4a5d7df314a5558dfb4549cda1a3ba9c"
//        const val API_KEY_MOVIE = "4a5d7df314a5558dfb4549cda1a3ba988"
        const val BASE_IMG_MOVIE = "https://image.tmdb.org/t/p/w342"

        const val BASE_URL = "https://api.nytimes.com"
        const val API = "q8M70IIQPeZXwqSrvtCF6OcCKYOPDk9p"
        const val TIMEOUT = 300000L
    }

    object QueryParam {
        const val MOVIE_QUERY = "query"
    }

    object EndPoint {
        const val POPULAR_MOVIE = "movie/popular"
        const val NOW_PLAYING_MOVIE = "movie/now_playing"
        const val SEARCH = "search/movie"

        fun similarMovieUrl(movieId: Int): String {
            return "movie/$movieId/similar"
        }

        fun creditUrl(id: Int): String {
            return "movie/$id/credits"
        }

        fun detailUrl(id: Int): String {
            return "movie/$id"
        }
    }
}