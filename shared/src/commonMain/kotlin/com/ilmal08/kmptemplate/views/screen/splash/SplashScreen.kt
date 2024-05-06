package com.ilmal08.kmptemplate.views.screen.splash

import KmpTemplate.shared.MR
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.data.source.local.KeyLocalStorage.KEY_EXAMPLE
import com.ilmal08.kmptemplate.data.source.local.localStorage
import com.ilmal08.kmptemplate.navigator.HomeTabNavigator
import com.ilmal08.kmptemplate.views.viewmodel.SplashViewModel
import com.russhwolf.settings.set
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(viewModel: SplashViewModel, navigator: Navigator) {
    LoadingSurfaceContent(navigator, viewModel)
}

@Composable
fun LoadingSurfaceContent(
    navigator: Navigator,
    viewModel: SplashViewModel
) {
    val isLoading = remember { mutableStateOf(true) }


    LaunchedEffect(Unit) {
        localStorage[KEY_EXAMPLE] = "local storage data dari splash screen"
        delay(2000)
        isLoading.value = false
        navigator.replace(HomeTabNavigator())
    }

    Surface(
        color = Color.White, modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading.value) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(MR.images.img_splash),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(vertical = 30.dp))
                    Text(stringResource(MR.strings.hello))
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                contentAlignment = Alignment.Center
            ) { }
        }
    }
}
