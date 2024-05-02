package com.ilmal08.kmptemplate.views.screen.home

import KmpTemplate.shared.MR
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import com.ilmal08.kmptemplate.views.components.NewsCard
import com.ilmal08.kmptemplate.views.state.BaseState
import com.ilmal08.kmptemplate.views.viewmodel.HomeViewModel
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun HomeContent2(
    screenModel: HomeViewModel,
    navigator: Navigator,
    state: BaseState
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = stringResource(MR.strings.application_name),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        )

        NewsContentHandler2(screenModel, state, navigator)
    }
}

@Composable
private fun NewsContentHandler2(
    screenModel: HomeViewModel,
    state: BaseState,
    navigator: Navigator
) {
    when(state) {
        is BaseState.Loading ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }


        is BaseState.Error -> {
            Text("error(also you can add custom error message from response here) depends on your api response standard")
        }

        is BaseState.Default -> {
            val data = screenModel.data.value?.resultResponses
            LazyColumn {
                data?.size?.let {
                    items(data) {
                        NewsCard(
                            data = it,
                            onClick = { navigator.push(DetailScreen(it)) }
                        )
                    }
                }
            }
        }

        else -> Unit
    }
}