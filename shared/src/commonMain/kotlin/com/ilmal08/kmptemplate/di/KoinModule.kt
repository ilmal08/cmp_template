package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.util.httpClient
import org.koin.dsl.module

val httpClientModule = module { single { httpClient } }

fun appModule() = listOf(
    httpClientModule,
    splashRepositoryModule,
    splashViewModelModule,
    repositoryModule2,
    presentationModule,
    remoteSourceModule
)