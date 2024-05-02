package com.ilmal08.kmptemplate.data.source.remote

import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.util.Constant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class HomeService(private val httpClient: HttpClient) {

    private val api = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=${Constant.API}"

    suspend fun getNews(): NewsResponse = httpClient.get(api).body()

}