package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.repository.HomeRepository
import com.ilmal08.kmptemplate.data.remote.HomeApiImpl
import com.ilmal08.kmptemplate.util.httpClient
import com.ilmal08.kmptemplate.views.viewmodel.HomeViewModel
import org.koin.dsl.module

val httpClientModule = module {
    single { httpClient }
}

val homeRepositoryModule = module {
    single<HomeRepository> { HomeApiImpl(get()) }
}

val homeViewModelModule = module {
    factory { HomeViewModel(get()) }
}

fun appModule() = listOf(
    httpClientModule,
    homeRepositoryModule,
    homeViewModelModule
)