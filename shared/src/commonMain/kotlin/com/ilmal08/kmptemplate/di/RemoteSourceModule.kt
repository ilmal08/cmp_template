package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.data.source.remote.HomeService
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val remoteSourceModule = module {
    factoryOf(::HomeService)
}