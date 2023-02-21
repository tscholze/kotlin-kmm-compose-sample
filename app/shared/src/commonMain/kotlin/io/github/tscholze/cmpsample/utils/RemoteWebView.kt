package io.github.tscholze.cmpsample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Multi platform web view composable that renders web site
 * for given url
 *
 * @param urlString Url to render
 * @param modifier Modifier that shall be applied
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 */
@Composable
internal expect fun RemoteWebView(urlString: String, modifier: Modifier)