package com.ilmal08.kmptemplate.views.screen.home

import KmpTemplate.shared.MR
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.domain.entity.movie.SearchMovieMap
import com.ilmal08.kmptemplate.util.ifNotNull
import com.ilmal08.kmptemplate.views.components.CardImageComponent
import com.ilmal08.kmptemplate.views.components.ContentLayout
import com.ilmal08.kmptemplate.views.components.DateComponent
import com.ilmal08.kmptemplate.views.components.ErrorScreen
import com.ilmal08.kmptemplate.views.components.LoadingComponent
import com.ilmal08.kmptemplate.views.components.RateComponent
import com.ilmal08.kmptemplate.views.components.SearchTextField
import com.ilmal08.kmptemplate.views.components.TextItem
import com.ilmal08.kmptemplate.views.screen.home.viewmodel.SearchViewModel
import com.ilmal08.kmptemplate.views.state.SearchState
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navigateToMovie: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val queryState by viewModel.query.collectAsState()
    val navigator: Navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(Unit) {
        viewModel.makeSearch()
    }

    ContentLayout(
        appbarTitle = stringResource(MR.strings.topbar_search),
        onBackPressed = { navigator.pop() }
    ) {
        uiState.error.ifNotNull {
            ErrorScreen(it)
        }

        SearchContent(uiState = uiState,
            query = queryState,
            handleQueryState = viewModel::handleQueryChange,
            onDetailClick = {
                navigateToMovie(it)
            }
        )
    }
}

@Composable
fun SearchContent(
    uiState: SearchState,
    query: String,
    handleQueryState: (String) -> Unit,
    onDetailClick: (Int) -> Unit,
) {
    Column {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                TextItem(
                    text = stringResource(MR.strings.search),
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.secondary
                )
                SearchTextField(
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    query = query,
                    onValueChange = handleQueryState
                )

                when {
                    uiState.isLoading -> {
                        LoadingComponent(
                            modifier = Modifier.padding(top = 100.dp),
                            contentAlignment = Alignment.TopCenter
                        )
                    }

                    !uiState.emptyState -> {
                        LazyColumn {
                            items(uiState.data) {
                                SearchRow(searchItem = it, onDetailClick = onDetailClick)
                            }
                        }
                    }

                    uiState.emptyState -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(MR.images.search_place_holder),
                                    contentDescription = null
                                )
                                TextItem(
                                    modifier = Modifier.padding(top = 8.dp),
                                    text = stringResource(MR.strings.empty_search),
                                    textColor = MaterialTheme.colorScheme.secondary,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchRow(
    searchItem: SearchMovieMap,
    onDetailClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
            .clickable {
                onDetailClick(searchItem.movieId)
            },
        shape = RoundedCornerShape(8.dp),
        colors = cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = cardElevation(5.dp)
    ) {
        Row {

            CardImageComponent(imagePath = searchItem.posterPath)

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextItem(
                    text = searchItem.title,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DateComponent(date = searchItem.releaseDate)
                    RateComponent(rate = searchItem.voteAverage.toString())
                }
            }
        }
    }
}