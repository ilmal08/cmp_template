package com.ilmal08.kmptemplate.views.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.data.source.local.KeyLocalStorage.KEY_EXAMPLE
import com.ilmal08.kmptemplate.data.source.local.localStorage
import com.ilmal08.kmptemplate.domain.entity.movie.NowPlayingMovie
import com.ilmal08.kmptemplate.domain.entity.movie.PopularMovie
import com.ilmal08.kmptemplate.util.Constant.DefaultValue.EMPTY_STRINGS
import com.ilmal08.kmptemplate.util.ifNotNull
import com.ilmal08.kmptemplate.views.components.CardImageComponent
import com.ilmal08.kmptemplate.views.components.DateComponent
import com.ilmal08.kmptemplate.views.components.ErrorScreen
import com.ilmal08.kmptemplate.views.components.LoadingComponent
import com.ilmal08.kmptemplate.views.components.PosterImageComponent
import com.ilmal08.kmptemplate.views.components.RateComponent
import com.ilmal08.kmptemplate.views.components.TextItem
import com.ilmal08.kmptemplate.views.screen.home.navigator.DetailNavigator
import com.ilmal08.kmptemplate.views.screen.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigator: Navigator
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(
            Modifier.fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        uiState.error.ifNotNull {
            ErrorScreen(it)
        }

        if (uiState.isLoading) {
            LoadingComponent()
        }

        SuccessContent(
            modifier = Modifier.weight(1f),
            popularMovieData = uiState.popularMovieData,
            nowPlayingMovieData = uiState.nowPlayingMovieData,
            navigator = navigator
        )
    }
}

@Composable
fun SuccessContent(
    modifier: Modifier = Modifier,
    popularMovieData: List<PopularMovie>,
    nowPlayingMovieData: List<NowPlayingMovie>,
    navigator: Navigator
) {
    LazyColumn(modifier = modifier) {
        item {
            HorizontalMoviePager(
                popularMovieData,
                onDetailClick = {
                    navigator.push(DetailNavigator(it))
                }
            )
        }
        items(nowPlayingMovieData) { nowPlayingMovies ->
            NowPlayingMovieRow(nowPlayingMovies = nowPlayingMovies) { id ->
                navigator.push(DetailNavigator(id))
            }
        }
    }
}

@Composable
fun NowPlayingMovieRow(
    nowPlayingMovies: NowPlayingMovie,
    onDetailClick: (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onDetailClick.invoke(nowPlayingMovies.movieId) },
        shape = MaterialTheme.shapes.small,
    ) {
        Row {

            CardImageComponent(imagePath = nowPlayingMovies.posterPath)

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextItem(
                    text = nowPlayingMovies.title,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DateComponent(date = nowPlayingMovies.releaseDate)
                    RateComponent(rate = nowPlayingMovies.voteAverage.toString())
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalMoviePager(
    popularMovie: List<PopularMovie>,
    onDetailClick: (Int) -> Unit,
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        popularMovie.size
    }

    Box {
        Surface(
            modifier = Modifier.fillMaxWidth().height(250.dp)
        ) {}
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextItem(
                    fontSize = 34.sp,
                    textColor = MaterialTheme.colorScheme.primaryContainer,
                    text = localStorage.getString(KEY_EXAMPLE, EMPTY_STRINGS)
                )
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                Card(
                    Modifier
                        .graphicsLayer {
                            val pageOffset = pagerState.currentPageOffsetFraction
                            lerp(
                                start = 0.65f,
                                stop = 1f,
                                fraction = 0.5f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }
                        }
                        .fillMaxWidth()
                        .clickable {
                            onDetailClick(popularMovie[page].movieId)
                        }
                        .aspectRatio(0.666f)) {
                    PosterImageComponent(imagePath = popularMovie[page].posterPath)
                }
            }
        }
    }
}