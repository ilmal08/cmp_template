package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.views.screen.home.viewmodel.HomeViewModel
import com.ilmal08.kmptemplate.views.screen.splash.viewmodel.SplashViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { HomeViewModel(get()) }
    factory { SplashViewModel(get()) }
}