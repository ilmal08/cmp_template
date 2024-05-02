package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.views.viewmodel.HomeViewModel
import com.ilmal08.kmptemplate.views.viewmodel.SplashViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val presentationModule = module {
    factoryOf(::HomeViewModel)
    factoryOf(::SplashViewModel)
}
