package com.ilmal08.kmptemplate.views.screen.home.navigator

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.screen.home.HomeScreen
import com.ilmal08.kmptemplate.views.screen.home.viewmodel.HomeViewModel

class HomeNavigator : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<HomeViewModel>()

        val navigator: Navigator = LocalNavigator.currentOrThrow

        HomeScreen(screenModel, navigator)
    }
}