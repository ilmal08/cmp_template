package com.ilmal08.kmptemplate.views.screen.setting

import KmpTemplate.shared.MR
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.ilmal08.kmptemplate.views.screen.setting.navigator.SettingNavigator
import dev.icerock.moko.resources.compose.stringResource
import kotlin.jvm.Transient

class SettingsTab(
    @Transient
    val onNavigator: (isRoot: Boolean) -> Unit,
) : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(MR.strings.setting_tab)
            val icon = rememberVectorPainter(Icons.Default.Settings)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = SettingNavigator(onNavigator)) { navigator ->
            onNavigator(navigator.lastItem is SettingNavigator)
            SlideTransition(navigator = navigator)
        }
    }
}