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