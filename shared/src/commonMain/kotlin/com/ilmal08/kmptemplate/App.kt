package com.ilmal08.kmptemplate

import androidx.compose.runtime.Composable
import com.ilmal08.kmptemplate.di.initKoin
import com.ilmal08.kmptemplate.views.screen.MainScreen
import com.ilmal08.kmptemplate.views.theme.AppTheme

@Composable
fun App() {
    initKoin()

    AppTheme {
        MainScreen()
    }

}