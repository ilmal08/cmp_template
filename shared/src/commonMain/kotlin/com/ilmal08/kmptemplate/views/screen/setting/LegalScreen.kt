package com.ilmal08.kmptemplate.views.screen.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.components.ContentLayout

@Composable
fun LegalScreen() {

    val navigator: Navigator = LocalNavigator.currentOrThrow

    ContentLayout(
        appbarTitle = "Legal",
        onBackPressed = { navigator.pop() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed non risus. Suspendisse lectus tortor, dignissim sit amet, " +
                        "adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. " +
                        "Maecenas ligula massa, varius a, semper congue, euismod non, mi. " +
                        "Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, " +
                        "non fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, " +
                        "scelerisque vitae, consequat in, pretium a, enim. Pellentesque congue. " +
                        "Ut in risus volutpat libero pharetra tempor. Cras vestibulum bibendum " +
                        "augue. Praesent egestas leo in pede. Praesent blandit odio eu enim. " +
                        "Pellentesque sed dui ut augue blandit sodales. Vestibulum ante ipsum " +
                        "primis in faucibus orci luctus et ultrices posuere cubilia Curae; " +
                        "Aliquam nibh. Mauris ac mauris sed pede pellentesque fermentum. " +
                        "Maecenas adipiscing ante non diam sodales hendrerit.",
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}