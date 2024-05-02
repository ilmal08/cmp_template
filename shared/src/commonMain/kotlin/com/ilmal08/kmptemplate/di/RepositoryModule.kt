package com.ilmal08.kmptemplate.di


import com.ilmal08.kmptemplate.domain.DispatcherHandler
import com.ilmal08.kmptemplate.data.source.remote.SplashApiImpl
import com.ilmal08.kmptemplate.domain.repository.HomeDataRepository
import com.ilmal08.kmptemplate.domain.repository.SplashRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

val splashRepositoryModule = module { single<SplashRepository> { SplashApiImpl(get()) } }

val repositoryModule2 = module {
    factory { Dispatchers.IO } bind CoroutineContext::class
    factory { DispatcherHandler.IO } bind DispatcherHandler::class
    factoryOf(::HomeDataRepository)
}

