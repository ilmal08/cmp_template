package com.ilmal08.kmptemplate.di

import com.ilmal08.kmptemplate.views.viewmodel.HomeViewModel
import com.ilmal08.kmptemplate.views.viewmodel.SplashViewModel
import org.koin.dsl.module

val splashViewModelModule = module { factory { SplashViewModel(get()) } }

val homeViewModelModule = module { factory { HomeViewModel(get()) } }