package com.ilmal08.kmptemplate.views.screen.setting

import KmpTemplate.shared.MR
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.permission.Permission
import com.ilmal08.kmptemplate.permission.isGranted
import com.ilmal08.kmptemplate.permission.rememberPermissionState
import com.ilmal08.kmptemplate.util.CameraScreen
import com.ilmal08.kmptemplate.views.screen.setting.navigator.LegalNavigator
import dev.icerock.moko.resources.compose.stringResource
import io.github.aakira.napier.Napier

@Composable
fun SettingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val navigator: Navigator = LocalNavigator.currentOrThrow

        val locationPermissionState = rememberPermissionState(Permission.LOCATION)
        val cameraPermissionState = rememberPermissionState(Permission.CAMERA)
        val galeryPermissionState = rememberPermissionState(Permission.GALLERY)

        val launchCamera = remember { mutableStateOf(false) }

        if (launchCamera.value) CameraScreen()

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).clickable {
                    navigator.push(LegalNavigator())
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = rememberVectorPainter(Icons.Default.Info),
                contentDescription = "Legal",
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(MR.strings.setting_legal_title),
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )

        ButtonList(
            buttonNames = listOf("Location", "Camera", "Galery"),
            onButtonClick = { buttonName ->
                when (buttonName) {
                    "Location" -> {
                        Napier.i("Location Click ${locationPermissionState.status.isGranted}")
                        locationPermissionState.launchPermissionRequest()
                    }
                    "Camera" -> {
                        Napier.i("Camera Click ${cameraPermissionState.status.isGranted}")
                        if(cameraPermissionState.status.isGranted) {
                            launchCamera.value = true
                        } else {
                            launchCamera.value = false
                            cameraPermissionState.launchPermissionRequest()
                        }
                    }
                    "Galery" -> {
                        Napier.i("Galery Click ${galeryPermissionState.status.isGranted}")
                        galeryPermissionState.launchPermissionRequest()
                    }
                }
            }
        )
    }
}

@Composable
fun ButtonList(
    buttonNames: List<String>,
    onButtonClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(buttonNames) { buttonName ->
            Button(
                onClick = {
                    onButtonClick(buttonName)

                },
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .fillMaxWidth(),

            ) {
                Text(buttonName)
            }
        }
    }
}