package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.data.repository.NewsApi
import com.ilmal08.kmptemplate.data.repository.NewsRepository
import com.ilmal08.kmptemplate.domain.NewsInteractor
import com.ilmal08.kmptemplate.domain.NewsUseCase
import org.koin.dsl.module

val newsModule = module {
    single<NewsRepository> { NewsApi() }
    single<NewsUseCase> { NewsInteractor(get()) }
}