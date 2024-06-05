package com.ilmal08.kmptemplate.views.screen.setting

import KmpTemplate.shared.MR
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.permission.Permission
import com.ilmal08.kmptemplate.permission.isGranted
import com.ilmal08.kmptemplate.permission.rememberPermissionState
import com.ilmal08.kmptemplate.util.imagePick.rememberCameraManager
import com.ilmal08.kmptemplate.util.imagePick.rememberGalleryManager
import com.ilmal08.kmptemplate.views.components.ImageSourceOptionDialog
import com.ilmal08.kmptemplate.views.screen.setting.navigator.LegalNavigator
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import io.github.aakira.napier.Napier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun SettingScreen(
    navigator: Navigator
) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coroutineScope = rememberCoroutineScope()
        val locationPermissionState = rememberPermissionState(Permission.LOCATION)
        val cameraPermissionState = rememberPermissionState(Permission.CAMERA)
        val galeryPermissionState = rememberPermissionState(Permission.GALLERY)
        var imageSourceOptionDialog by remember { mutableStateOf(value = false) }
        var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
        var launchGallery by remember { mutableStateOf(value = false) }
        var launchCamera by remember { mutableStateOf(value = false) }

        val cameraManager = rememberCameraManager {
            coroutineScope.launch {
                val bitmap = withContext(Dispatchers.Default) {
                    it?.toImageBitmap()
                }
                imageBitmap = bitmap
            }
        }

        val galleryManager = rememberGalleryManager {
            coroutineScope.launch {
                val bitmap = withContext(Dispatchers.Default) {
                    it?.toImageBitmap()
                }
                imageBitmap = bitmap
            }
        }

        if (launchGallery) {
            if (galeryPermissionState.status.isGranted) {
                galleryManager.launch()
            } else {
                galeryPermissionState.launchPermissionRequest()
            }
            launchGallery = false
        }

        if (launchCamera) {
            if (cameraPermissionState.status.isGranted) {
                cameraManager.launch()
            } else {
                cameraPermissionState.launchPermissionRequest()
            }
            launchCamera = false
        }

        if (imageSourceOptionDialog) {
            ImageSourceOptionDialog(onDismissRequest = {
                imageSourceOptionDialog = false
            }, onGalleryRequest = {
                imageSourceOptionDialog = false
                launchGallery = true
            }, onCameraRequest = {
                imageSourceOptionDialog = false
                launchCamera = true
            })
        }

        ProfileCard(imageBitmap = imageBitmap,
            fullName = "John Doel",
            email = "john_doel@email.com",
            phoneNumber = "+6969876543210",
            openModal = {
                imageSourceOptionDialog = it
            })

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

        ButtonList(buttonNames = listOf("Location", "Camera", "Galery"),
            onButtonClick = { buttonName ->
                when (buttonName) {
                    "Location" -> {
                        Napier.i("Location Click ${locationPermissionState.status.isGranted}")
                        locationPermissionState.launchPermissionRequest()
                    }

                    "Camera" -> {
                        Napier.i("Camera Click ${cameraPermissionState.status.isGranted}")
                        if (cameraPermissionState.status.isGranted) {
                            cameraManager.launch()
                        } else {
                            cameraPermissionState.launchPermissionRequest()
                        }
                    }

                    "Galery" -> {
                        Napier.i("Galery Click ${galeryPermissionState.status.isGranted}")
                        galeryPermissionState.launchPermissionRequest()
                    }
                }
            })
    }
}

@Composable
fun ButtonList(
    buttonNames: List<String>,
    onButtonClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(buttonNames) { buttonName ->
            Button(
                onClick = {
                    onButtonClick(buttonName)

                },
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp).fillMaxWidth(),

                ) {
                Text(buttonName)
            }
        }
    }
}

@Composable
fun ProfileCard(
    imageBitmap: ImageBitmap?,
    fullName: String,
    email: String,
    phoneNumber: String,
    openModal: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)
        ) {
            ProfilePicBox(
                imageBitmap = imageBitmap, openModal = openModal
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = fullName, color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = email, color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = phoneNumber, color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}

@Composable
fun ProfilePicBox(
    imageBitmap: ImageBitmap?, openModal: (Boolean) -> Unit
) {
    Box(modifier = Modifier.padding(all = 8.dp).clickable {
        openModal(true)
    }) {
        if (imageBitmap == null) {
            Image(
                painter = painterResource(MR.images.img_splash),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(100.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                bitmap = imageBitmap,
                modifier = Modifier.size(100.dp).clip(CircleShape),
                contentDescription = "Profile",
                contentScale = ContentScale.Crop,
            )
        }
    }
}