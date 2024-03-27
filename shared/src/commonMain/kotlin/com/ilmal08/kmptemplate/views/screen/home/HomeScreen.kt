package com.ilmal08.kmptemplate.views.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.repository.MainRepository
import com.ilmal08.kmptemplate.views.components.NewsCard
import com.ilmal08.kmptemplate.views.state.NewsState
import com.ilmal08.kmptemplate.views.state.NewsState.Error
import com.ilmal08.kmptemplate.views.state.NewsState.Loading
import com.ilmal08.kmptemplate.views.state.NewsState.Success
import com.ilmal08.kmptemplate.views.viewmodel.BaseViewModel

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val repository by remember { mutableStateOf(MainRepository()) }
        val viewModel by remember { mutableStateOf(BaseViewModel(repository)) }
        var isHomeNews by remember { mutableStateOf(false) }

        val state by viewModel.newsHome.collectAsState()
        var newsState by remember { mutableStateOf<NewsState>(Loading) }

        newsState = state

        LaunchedEffect(isHomeNews) { viewModel.getHome() }

        val navigator: Navigator = LocalNavigator.currentOrThrow

        HomeContent(navigator, newsState)
    }
}

@Composable
private fun HomeContent(
    navigator: Navigator,
    newsState: NewsState
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Home",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        )

        NewsContentHandler(newsState, navigator)
    }
}

@Composable
private fun NewsContentHandler(
    newsState: NewsState,
    navigator: Navigator
) {
    when(newsState) {
        is Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Error -> {
            val error = (newsState).error
            Text(error)
        }

        is Success -> {
            val response = (newsState).news
            LazyColumn {
                items(response.resultResponses) { item ->
                    NewsCard(
                        data = item,
                        onClick = { navigator.push(DetailScreen(item)) }
                    )
                }
            }
        }
    }
}