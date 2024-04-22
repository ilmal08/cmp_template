package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.data.repository.HomeRepository
import com.ilmal08.kmptemplate.data.repository.HomeRepositoryImpl
import com.ilmal08.kmptemplate.util.httpClient
import com.ilmal08.kmptemplate.views.viewmodel.HomeViewModel
import org.koin.dsl.module

val httpClientModule = module {
    single { httpClient }
}

val homeRepositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
}

val homeViewModelModule = module {
    factory { HomeViewModel(get()) }
}

fun appModule() = listOf(
    httpClientModule,
    homeRepositoryModule,
    homeViewModelModule
)