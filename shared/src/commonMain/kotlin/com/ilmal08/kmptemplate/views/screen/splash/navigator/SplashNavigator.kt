package com.ilmal08.kmptemplate.views.screen.splash.navigator

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.screen.splash.SplashScreen
import com.ilmal08.kmptemplate.views.screen.splash.viewmodel.SplashViewModel

class SplashNavigator : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SplashViewModel>()

        SplashScreen(
            viewModel = screenModel,
            navigator = navigator
        )
    }
}