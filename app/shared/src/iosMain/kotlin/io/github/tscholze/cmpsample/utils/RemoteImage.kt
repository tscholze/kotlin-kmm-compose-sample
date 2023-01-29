package io.github.tscholze.cmpsample.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import io.ktor.client.*

@Composable
internal actual fun __RemoteImage(
    client: HttpClient,
    imageUrl: String,
    modifier: Modifier,
    contentDescription: String?
) {
    CompositionLocalProvider {
        Text("Image")
    }
}