package com.ilmal08.kmptemplate.views.screen.home.navigator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.ilmal08.kmptemplate.views.screen.home.HomeTab
import com.ilmal08.kmptemplate.views.screen.setting.SettingsTab

class HomeTabNavigator : Screen {

    @Composable
    override fun Content() {
        var isVisible by remember { mutableStateOf(true) }

//        var isPadding by remember { mutableStateOf(true) }

        val homeTab = remember {
            HomeTab(
                onNavigator = { isVisible = it }
            )
        }

        val settingsTab = remember {
            SettingsTab(
                onNavigator = { isVisible = it }
            )
        }

        TabNavigator(tab = homeTab) {
            Scaffold(
                modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                bottomBar = {
                    AnimatedVisibility(visible = isVisible, enter = slideInVertically { height ->
                        height
                    }, exit = slideOutVertically { height ->
                        height
                    }) {
                        BottomNavigation {
                            TabNavigationItem(homeTab)
                            TabNavigationItem(settingsTab)
                        }
                    }
                },
                content = { innerPadding ->
                    Box(
                        modifier = Modifier.padding(
                            top = innerPadding.calculateTopPadding(),
                            bottom = if (isVisible) {innerPadding.calculateBottomPadding() } else 0.dp
                        )
                    ) { CurrentTab() }
                },
            )
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator: TabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription =
                    tab.options.title
                )
            }
        },
        label = {
            Text(
                text = tab.options.title
            )
        }
    )
}
