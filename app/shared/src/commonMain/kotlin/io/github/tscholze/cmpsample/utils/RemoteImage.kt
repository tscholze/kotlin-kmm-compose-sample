package io.github.tscholze.cmpsample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.ktor.client.*

/**
 * Multi platform image view composable that fetches it's image
 * from given url.
 *
 * @param client Platform-specific HttpClient that shall be used
 * @param imageUrl Source url of the image
 * @param modifier Compose modifiers that shall be applied
 * @param contentDescription Readable description of what is displayed.
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
@Composable
internal expect fun RemoteImage(
    client: HttpClient,
    imageUrl: String,
    modifier: Modifier,
    contentDescription: String
)