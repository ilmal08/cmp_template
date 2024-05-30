package com.ilmal08.kmptemplate.views.screen.setting

import KmpTemplate.shared.MR
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ilmal08.kmptemplate.views.components.ContentLayout
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun LegalScreen() {

    val navigator: Navigator = LocalNavigator.currentOrThrow
    val scrollState = rememberScrollState()

    ContentLayout(
        appbarTitle = stringResource(MR.strings.setting_legal_title),
        onBackPressed = { navigator.pop() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = stringResource(MR.strings.terms_of_use),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(MR.strings.acceptance),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary

            )
            Text(
                text = stringResource(MR.strings.usage),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.intellectual_property),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.updates),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.liability),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                text = stringResource(MR.strings.privacy_policy),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(MR.strings.information_collection),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.information_use),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.information_sharing),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.information_security),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.your_rights),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.privacy_changes),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = stringResource(MR.strings.contact_us),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}