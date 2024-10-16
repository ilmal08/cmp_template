package com.ilmal08.kmptemplate.views.screen.home

import KmpTemplate.shared.MR
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.ilmal08.kmptemplate.views.screen.home.navigator.HomeNavigator
import dev.icerock.moko.resources.compose.stringResource

class HomeTab(
//    val onNavigator: (isRoot: Boolean) -> Unit
) : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(MR.strings.home_tab)
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(
            screen = HomeNavigator(
//                onNavigator
            )
        ) { navigator ->
//            onNavigator(navigator.lastItem is HomeNavigator)
            SlideTransition(navigator = navigator)
        }
    }
}