package com.ilmal08.kmptemplate.di


import com.ilmal08.kmptemplate.domain.DispatcherHandler
import com.ilmal08.kmptemplate.domain.repository.HomeDataRepository
import com.ilmal08.kmptemplate.domain.repository.SplashDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

val repositoryModule = module {
    factory { Dispatchers.IO } bind CoroutineContext::class
    factory { DispatcherHandler.IO } bind DispatcherHandler::class
    factoryOf(::HomeDataRepository)
    factoryOf(::SplashDataRepository)
}

