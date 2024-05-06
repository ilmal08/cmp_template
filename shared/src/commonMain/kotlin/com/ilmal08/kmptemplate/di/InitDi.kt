package com.ilmal08.kmptemplate.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            networkModule,
            repositoryModule,
            viewModelModule
        )
    }
}