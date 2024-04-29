package com.ilmal08.kmptemplate.di


import com.ilmal08.kmptemplate.data.remote.HomeApiImpl
import com.ilmal08.kmptemplate.data.remote.SplashApiImpl
import com.ilmal08.kmptemplate.repository.HomeRepository
import com.ilmal08.kmptemplate.repository.SplashRepository
import org.koin.dsl.module

val splashRepositoryModule = module { single<SplashRepository> { SplashApiImpl(get()) } }

val homeRepositoryModule = module { single<HomeRepository> { HomeApiImpl(get()) } }


