package com.ilmal08.kmptemplate.views.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.navigator.LocalMainNavigator
import com.ilmal08.kmptemplate.navigator.SplashNavigator
import com.ilmal08.kmptemplate.util.logger


@Composable
fun MainScreen() {

    Navigator(SplashNavigator()) {
        CompositionLocalProvider(LocalMainNavigator provides it) {
            CurrentScreen()
        }
    }

    LaunchedEffect(Unit) {
        logger.i("App started")
    }
}