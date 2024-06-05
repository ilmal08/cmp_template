package com.ilmal08.kmptemplate.util.imagePick

import androidx.compose.runtime.Composable
import com.ilmal08.kmptemplate.util.SharedImage

@Composable
expect fun rememberCameraManager(onResult: (SharedImage?) -> Unit): CameraManager


expect class CameraManager(
    onLaunch: () -> Unit
) {
    fun launch()
}