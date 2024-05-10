package com.ilmal08.kmptemplate.views.screen.setting.navigator

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.ilmal08.kmptemplate.views.screen.setting.LegalScreen

class LegalNavigator : Screen {
    @Composable
    override fun Content() {
        LegalScreen()
    }
}