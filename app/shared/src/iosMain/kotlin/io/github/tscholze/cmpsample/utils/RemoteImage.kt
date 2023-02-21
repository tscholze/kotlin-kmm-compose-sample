package io.github.tscholze.cmpsample.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.launch
import org.jetbrains.skia.Image

/**
 * iOS implementation of a KMM image view composable that fetches it's image
 * from given url.
 *
 * Actual: iOS implementation.
 *
 * @param client Platform-specific HttpClient that shall be used
 * @param imageUrl Source url of the image
 * @param modifier Compose modifiers that shall be applied
 * @param contentDescription Readable description of what is displayed.
 */
@Composable
internal actual fun RemoteImage(
    client: HttpClient,
    imageUrl: String,
    modifier: Modifier,
    contentDescription: String
) {
    // MARK: - Properties -

    val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }
    val scope = rememberCoroutineScope()

    // MARK: - Events -

    scope.launch {
        imageBitmap.value = loadPicture(client, imageUrl)
    }

    // MARK: - UI -

    CompositionLocalProvider {
        if (imageBitmap.value != null) {
            Image(
                bitmap = imageBitmap.value!!,
                contentDescription
            )
        } else {
            Box(
                modifier = modifier.background(MaterialTheme.colors.surface)
            )
        }
    }
}

// MARK: - Private helper -

private suspend fun loadPicture(client: HttpClient, url: String): ImageBitmap {
    val httpResponse: HttpResponse = client.get(url)
    val bytes = httpResponse.body<ByteArray>()

    return  Image.makeFromEncoded(bytes).toComposeImageBitmap()
}



