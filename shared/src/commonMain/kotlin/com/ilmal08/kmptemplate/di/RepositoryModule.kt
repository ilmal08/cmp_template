package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.data.repository.MovieRepositoryImpl
import com.ilmal08.kmptemplate.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}