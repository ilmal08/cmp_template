package com.ilmal08.kmptemplate.views.screen.home.navigator

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.screen.home.DetailScreen
import com.ilmal08.kmptemplate.views.screen.home.viewmodel.DetailViewModel

class DetailNavigator(private val movieId: Int) : Screen {

    override val key = "DETAIL_SCREEN"

    @Composable
    override fun Content() {

        val screenModel = getScreenModel<DetailViewModel>()

        val navigator: Navigator = LocalNavigator.currentOrThrow

        DetailScreen(screenModel, navigator, id = movieId)
    }
}