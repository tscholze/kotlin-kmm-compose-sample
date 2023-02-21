package io.github.tscholze.cmpsample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal expect fun RemoteWebView(urlString: String, modifier: Modifier)