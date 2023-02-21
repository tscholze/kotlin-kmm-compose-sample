package io.github.tscholze.cmpsample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
internal  actual fun RemoteWebView(urlString: String, modifier: Modifier) {

    // MARK: - Properties -

    val state = rememberWebViewState(urlString)

    // MARK: - UI -

    WebView(
        state,
        modifier = modifier
    )
}