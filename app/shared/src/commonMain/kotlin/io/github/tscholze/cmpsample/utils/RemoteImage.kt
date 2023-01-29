package io.github.tscholze.cmpsample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.ktor.client.*

@Suppress("NO_ACTUAL_FOR_EXPECT")
@Composable
internal expect fun __RemoteImage(
    client: HttpClient,
    imageUrl: String,
    modifier: Modifier,
    contentDescription: String? = null
)