package io.github.tscholze.cmpsample.composables.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
internal fun CMPAppBar() {
    TopAppBar(
        title = { Text(text = "AppBar") }
    )
}