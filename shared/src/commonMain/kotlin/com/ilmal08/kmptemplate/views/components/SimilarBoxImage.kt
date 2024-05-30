package com.ilmal08.kmptemplate.views.components

import KmpTemplate.shared.MR
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ilmal08.kmptemplate.util.Constant
import com.seiko.imageloader.rememberAsyncImagePainter
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun SimilarBoxImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    Image(
        painter = if (imageUrl.isNullOrEmpty()) {
            painterResource(MR.images.img_splash)
        } else {
            rememberAsyncImagePainter(
                Constant.ApiConfig.BASE_IMG_MOVIE.plus(imageUrl)
            )
        },
        contentDescription = "Avatar",
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.FillWidth
    )
}