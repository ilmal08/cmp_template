package com.ilmal08.kmptemplate.views.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.navigator.LocalMainNavigator
import com.ilmal08.kmptemplate.views.screen.splash.navigator.SplashNavigator
import kotlinx.coroutines.CoroutineScope

@OptIn(InternalVoyagerApi::class)
@Composable
fun MainScreen() {

    Navigator(SplashNavigator()) {
        CompositionLocalProvider(LocalMainNavigator provides it) {
            CurrentScreen()
        }
    }
}

@Composable
fun <T> LaunchedEffectKeyed(
    key: T,
    onAction: suspend CoroutineScope.(key: T) -> Unit
) = LaunchedEffect(key) { onAction(key) }