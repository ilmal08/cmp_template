package com.ilmal08.kmptemplate.views.screen.home.navigator

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.screen.home.SearchScreen
import com.ilmal08.kmptemplate.views.screen.home.viewmodel.SearchViewModel

class SearchNavigator() : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<SearchViewModel>()

        val navigator: Navigator = LocalNavigator.currentOrThrow

//        LaunchedEffect(Unit) {
//            onNavigator(navigator.lastItem is SearchNavigator)
//        }

        SearchScreen(
            viewModel = screenModel,
            navigateToMovie = { navigator.push(DetailNavigator(it)) }
        )
    }
}