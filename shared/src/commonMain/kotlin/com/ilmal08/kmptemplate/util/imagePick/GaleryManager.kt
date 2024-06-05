package com.ilmal08.kmptemplate.util.imagePick

import androidx.compose.runtime.Composable
import com.ilmal08.kmptemplate.util.SharedImage

@Composable
expect fun rememberGalleryManager(onResult: (SharedImage?) -> Unit): GalleryManager


expect class GalleryManager(
    onLaunch: () -> Unit
) {
    fun launch()
}