package io.github.tscholze.cmpsample.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.core.*
import org.jetbrains.skia.Image

@Composable
internal actual fun RemoteImage(
    client: HttpClient,
    imageUrl: String,
    modifier: Modifier,
    contentDescription: String
) {

    val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(key1 = imageUrl) {
        imageBitmap.value = loadPicture(client, imageUrl)
    }

    CompositionLocalProvider {
        if (imageBitmap.value != null) {
            Image(bitmap = imageBitmap.value!!, "content description")
        }
    }
}

suspend fun loadPicture(client: HttpClient, url: String): ImageBitmap {
    val image = client.use { client ->
        client.get(url).bodyAsText().toByteArray()
    }

    return  Image.makeFromEncoded(image).toComposeImageBitmap()
}



