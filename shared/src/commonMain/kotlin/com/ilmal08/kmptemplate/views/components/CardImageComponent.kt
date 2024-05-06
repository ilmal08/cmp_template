package com.ilmal08.kmptemplate.views.components

import KmpTemplate.shared.MR
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ilmal08.kmptemplate.util.Constant.ApiConfig.BASE_IMG_MOVIE
import com.seiko.imageloader.rememberAsyncImagePainter
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun CardImageComponent(
    modifier: Modifier = Modifier,
    imagePath: String?,
    contentScale: ContentScale = ContentScale.Crop
) {

    Image(
        painter = if (imagePath.isNullOrEmpty()) {
            painterResource(MR.images.img_splash)
        } else {
            rememberAsyncImagePainter(
                BASE_IMG_MOVIE.plus(imagePath)
            )
        },
        contentDescription = null,
        modifier = modifier.size(width = 100.dp, height = 150.dp),
        contentScale = contentScale,
    )
}