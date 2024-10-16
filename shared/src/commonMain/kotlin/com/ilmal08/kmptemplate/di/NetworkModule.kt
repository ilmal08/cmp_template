package com.ilmal08.kmptemplate.di

import androidx.compose.ui.text.intl.Locale
import com.ilmal08.kmptemplate.data.source.remote.MovieService
import com.ilmal08.kmptemplate.data.source.remote.impl.MovieServiceImpl
import com.ilmal08.kmptemplate.util.Constant.ApiConfig.API_KEY_MOVIE
import com.ilmal08.kmptemplate.util.Constant.ApiConfig.BASE_URL_MOVIE
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {
    val getLocale = Locale.current.language
    val language = if(getLocale == "in") "id" else "en"

    single {
        HttpClient {
            defaultRequest {
                url {
                    if (this.host.isBlank()) {
                        takeFrom(BASE_URL_MOVIE)
                        parameters.append("api_key", API_KEY_MOVIE)
                        parameters.append("language", language)
                        parameters.append("include_adult", true.toString())
                    }
                }
            }

            expectSuccess = true

            install(HttpTimeout) {
                val timeout = 30000L
                connectTimeoutMillis = timeout
                requestTimeoutMillis = timeout
                socketTimeoutMillis = timeout
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(tag = "HTTP REQUEST", message = message)
                    }
                }
                level = LogLevel.BODY
            }

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }

        }.also {
            Napier.base(DebugAntilog())
        }
    }
    single<MovieService> { MovieServiceImpl(get()) }
}