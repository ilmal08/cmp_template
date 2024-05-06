package com.ilmal08.kmptemplate.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import com.ilmal08.kmptemplate.util.Constant.ApiConfig.BASE_IMG_MOVIE
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.asImageBitmap
import com.seiko.imageloader.model.ImageRequest
import com.seiko.imageloader.model.ImageResult
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun DetailPosterComponent(
    modifier: Modifier = Modifier,
    imagePath: String?
) {
    val url = BASE_IMG_MOVIE.plus(imagePath)
    val request = remember(url) { ImageRequest(url) }
    val imageLoader = LocalImageLoader.current
    var viewWidth by remember { mutableStateOf(0) }
    val statusBarHeight = WindowInsets.statusBars.getTop(LocalDensity.current)


    Image(
        modifier = modifier.fillMaxSize().onGloballyPositioned {
            viewWidth = it.size.width
        },
        painter = rememberAsyncImagePainter(request, imageLoader),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )

    LaunchedEffect(imagePath) {
        val imageBitmap = when (val imageResult = imageLoader.execute(request)) {
            is ImageResult.Bitmap -> imageResult.bitmap.asImageBitmap()

            else -> null
        }
    }
}