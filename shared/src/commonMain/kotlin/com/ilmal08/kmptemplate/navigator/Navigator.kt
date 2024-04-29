package com.ilmal08.kmptemplate.navigator

import androidx.compose.runtime.staticCompositionLocalOf
import cafe.adriel.voyager.navigator.Navigator

val LocalMainNavigator = staticCompositionLocalOf<Navigator> { error("no navigator provided!") }