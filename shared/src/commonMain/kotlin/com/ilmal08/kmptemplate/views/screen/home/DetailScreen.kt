package com.ilmal08.kmptemplate.views.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.domain.entity.movie.AllDetailMovie
import com.ilmal08.kmptemplate.util.ifNotNull
import com.ilmal08.kmptemplate.views.components.CircleAvatarComponent
import com.ilmal08.kmptemplate.views.components.ContentLayout
import com.ilmal08.kmptemplate.views.components.DetailPosterComponent
import com.ilmal08.kmptemplate.views.components.ErrorScreen
import com.ilmal08.kmptemplate.views.components.LoadingComponent
import com.ilmal08.kmptemplate.views.screen.home.viewmodel.DetailViewModel
import com.ilmal08.kmptemplate.views.state.DetailState

@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    navigator: Navigator,
    id: Int
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData(id)
    }

    uiState.error.ifNotNull {
        ErrorScreen(it)
    }

    if (uiState.isLoading) {
        LoadingComponent()
    }

    ContentLayout(
        appbarTitle = "Detail",
        onBackPressed = { navigator.pop() }
    ) {
        SuccessContent(uiState)
    }
}

@Composable
private fun SuccessContent(
    state: DetailState
) {
    LazyColumn {
        item {
            DetailSection(state.detailMovie)
        }

        item {
            CreditSection(state)
        }
    }
}

@Composable
private fun DetailSection(
    data: AllDetailMovie
) {
    Column {
        DetailPosterComponent(
            modifier = Modifier.fillMaxWidth(),
            imagePath = data.posterPath
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = data.title,
            style = MaterialTheme.typography.h4,
            color = colorScheme.secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Release: ${data.releaseDate}",
            style = MaterialTheme.typography.body1,
            color = colorScheme.secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Overview:",
            style = MaterialTheme.typography.subtitle1,
            color = colorScheme.secondary,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = data.overview,
            style = MaterialTheme.typography.body1,
            color = colorScheme.secondary,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
private fun CreditSection(state: DetailState) {
    Column {
        Text(
            text = "Cast",
            style = MaterialTheme.typography.subtitle1,
            color = colorScheme.secondary,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(state.detailMovie.credit) {
                Spacer(modifier = Modifier.height(30.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(end = 20.dp)
                ) {
                    CircleAvatarComponent(
                        size = 80.dp,
                        imageUrl = it.profilePath
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = it.originalName,
                        style = MaterialTheme.typography.body1,
                        color = colorScheme.secondary,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = it.character,
                        style = MaterialTheme.typography.body2,
                        color = colorScheme.secondary,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}