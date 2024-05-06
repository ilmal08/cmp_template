package com.ilmal08.kmptemplate.navigator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.ilmal08.kmptemplate.domain.entity.ResultEntity
import com.ilmal08.kmptemplate.views.screen.home.DetailItem

class DetailNavigator(private val result: ResultEntity) : Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {
            DetailItem(result)
        }
    }
}