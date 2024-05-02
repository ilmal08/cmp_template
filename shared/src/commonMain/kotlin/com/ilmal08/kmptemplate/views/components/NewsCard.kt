package com.ilmal08.kmptemplate.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import com.ilmal08.kmptemplate.domain.entity.ResultEntity
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun NewsCard(
    data: ResultEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                Logger.d { "NEWS CARD CLICK" }
                Logger.d { "$data" }
                onClick()
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            data.multimediaResponse?.let {
                KamelImage(
                    resource = asyncPainterResource(data = data.multimediaResponse[0].url),
                    contentDescription = "description"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = data.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = data.abstract,
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )
        }
    }
}