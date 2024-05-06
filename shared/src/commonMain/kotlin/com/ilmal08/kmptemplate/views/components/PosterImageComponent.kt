package com.ilmal08.kmptemplate.views.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.ilmal08.kmptemplate.util.Constant
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun PosterImageComponent(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    imagePath: String?
) {
    KamelImage(
        modifier = modifier.fillMaxSize(),
        resource = asyncPainterResource(
           Constant.ApiConfig.BASE_IMG_MOVIE.plus(imagePath)
        ),
        contentDescription = "description",
        contentScale = contentScale
    )
}