package com.ilmal08.kmptemplate.data.remote

import com.ilmal08.kmptemplate.repository.SplashRepository
import io.ktor.client.HttpClient

class SplashApiImpl(private val httpClient: HttpClient) : SplashRepository {

}