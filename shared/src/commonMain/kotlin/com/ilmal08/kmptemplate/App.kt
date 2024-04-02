package com.ilmal08.kmptemplate

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.ilmal08.kmptemplate.di.newsModule
import com.ilmal08.kmptemplate.views.screen.MainScreen
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

@Composable
fun App() {
    startKoin {
        modules(newsModule)
    }
    MaterialTheme {
        MainScreen()
    }
}