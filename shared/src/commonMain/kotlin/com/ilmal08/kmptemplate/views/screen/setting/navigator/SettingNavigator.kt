package com.ilmal08.kmptemplate.views.screen.setting.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.screen.setting.SettingScreen

class SettingNavigator(
    val onNavigator: (isRoot: Boolean) -> Unit
) : Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            onNavigator(navigator.lastItem is SettingNavigator)
        }

        SettingScreen()
    }
}