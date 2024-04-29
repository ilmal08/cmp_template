package com.ilmal08.kmptemplate.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.screen.home.HomeContent2
import com.ilmal08.kmptemplate.views.viewmodel.HomeViewModel

class HomeNavigator : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<HomeViewModel>()
        val state by screenModel.state.collectAsState()

        val navigator: Navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = screenModel) {
            screenModel.getNews()
        }

        HomeContent2(screenModel, navigator, state)
    }
}