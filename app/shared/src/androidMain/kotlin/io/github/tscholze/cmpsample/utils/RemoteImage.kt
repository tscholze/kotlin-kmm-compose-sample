package io.github.tscholze.cmpsample.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import io.ktor.client.*

/**
 * Android implementation of a KMM image view composable that fetches it's image
 * from given url.
 *
 * @param client Platform-specific HttpClient that shall be used
 * @param imageUrl Source url of the image
 * @param modifier Compose modifiers that shall be applied
 * @param contentDescription Readable description of what is displayed.
 *
 * common: commonMain/utils/
 * iOS: iosMain/utils/
 */
@SuppressLint("ComposableNaming")
@Composable
internal actual fun RemoteImage(client: HttpClient, imageUrl: String, modifier: Modifier, contentDescription: String) {
    val painter = rememberImagePainter(
        data = imageUrl,
        imageLoader = LocalImageLoader.current,
        builder = {
            placeholder(0)
        }
    )

    Column() {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}