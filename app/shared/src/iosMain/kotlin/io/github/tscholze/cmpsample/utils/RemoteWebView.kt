package io.github.tscholze.cmpsample.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.WebKit.WKWebView


/**
 * iOS implementation of a multi platform web view composable
 * that renders web site for given url
 *
 * Actual: iOS implementation.
 *
 * Caution: This feature is currently not supported in KMM
 * https://github.com/JetBrains/androidx/pull/386/commits/9172718a05550e9db152f7ff4c250b0132f59115#diff-188d07c3a7341d7123298c358860432f11799968fcfae5d711f9fe07e457df37R125
 *
 * @param urlString Url to render
 * @param modifier Modifier that shall be applied
*/
@Composable
internal  actual fun RemoteWebView(urlString: String, modifier: Modifier) {

    // MARK: - Properties -

    val request = NSURLRequest(NSURL(string = urlString))
    val webView = WKWebView()
    val scope = rememberCoroutineScope()

    // MARK: - Events -

    scope.launch {
        webView.loadRequest(request)
    }

    // MARK: - UI -
    CompositionLocalProvider {
        Box(modifier = modifier.background(Color.Red)) {
            Text("Not supported in Jetpack Compose, yet")
        }
    }
}