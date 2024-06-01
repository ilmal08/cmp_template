package com.ilmal08.kmptemplate.data.source.remote.impl

import com.ilmal08.kmptemplate.data.model.response.movie.CreditMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.DetailMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.NowPlayingResponse
import com.ilmal08.kmptemplate.data.model.response.movie.PopularMovieResponse
import com.ilmal08.kmptemplate.data.model.response.movie.SearchResponse
import com.ilmal08.kmptemplate.data.model.response.movie.SimilarResponse
import com.ilmal08.kmptemplate.data.source.remote.MovieService
import com.ilmal08.kmptemplate.util.Constant.EndPoint.NOW_PLAYING_MOVIE
import com.ilmal08.kmptemplate.util.Constant.EndPoint.POPULAR_MOVIE
import com.ilmal08.kmptemplate.util.Constant.EndPoint.SEARCH
import com.ilmal08.kmptemplate.util.Constant.EndPoint.creditUrl
import com.ilmal08.kmptemplate.util.Constant.EndPoint.detailUrl
import com.ilmal08.kmptemplate.util.Constant.EndPoint.similarMovieUrl
import com.ilmal08.kmptemplate.util.Constant.QueryParam.MOVIE_QUERY
import com.ilmal08.kmptemplate.util.handleApiResult
import com.ilmal08.kmptemplate.util.runBlockingWithResult
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.runBlocking

class MovieServiceImpl(
    private val client: HttpClient,
) : MovieService {
    override suspend fun popularMovie(): PopularMovieResponse {
        val result = runBlocking(Dispatchers.IO) {
            runBlockingWithResult<PopularMovieResponse>(client) {
                client.get(POPULAR_MOVIE)
            }
        }
        return handleApiResult(result)
    }

    override suspend fun nowPlaying(): NowPlayingResponse {
        val result = runBlocking(Dispatchers.IO) {
            runBlockingWithResult<NowPlayingResponse>(client) {
                client.get(NOW_PLAYING_MOVIE)
            }
        }
        return handleApiResult(result)
    }

    override suspend fun detail(id: Int): DetailMovieResponse {
        val result = runBlocking(Dispatchers.IO) {
            runBlockingWithResult<DetailMovieResponse>(client) {
                client.get(detailUrl(id))
            }
        }
        return handleApiResult(result)
    }

    override suspend fun credit(id: Int): CreditMovieResponse {
        val result = runBlocking(Dispatchers.IO) {
            runBlockingWithResult<CreditMovieResponse>(client) {
                client.get(creditUrl(id))
            }
        }
        return handleApiResult(result)
    }

    override suspend fun similarMovie(id: Int): SimilarResponse {
        val result = runBlocking(Dispatchers.IO) {
            runBlockingWithResult<SimilarResponse>(client) {
                client.get(similarMovieUrl(id))
            }
        }
        return handleApiResult(result)
    }

    override suspend fun searchMovie(query: String): SearchResponse {
        val result = runBlocking(Dispatchers.IO) {
            runBlockingWithResult<SearchResponse>(client) {
                client.get(SEARCH) {
                    url { parameters.append(MOVIE_QUERY, query) }
                }
            }
        }
        return handleApiResult(result)
    }
}