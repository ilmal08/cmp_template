package com.ilmal08.kmptemplate.data.source.remote

import com.ilmal08.kmptemplate.domain.repository.SplashRepository
import io.ktor.client.HttpClient

class SplashApiImpl(private val httpClient: HttpClient) : SplashRepository