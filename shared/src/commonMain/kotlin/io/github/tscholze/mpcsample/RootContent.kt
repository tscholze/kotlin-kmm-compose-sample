package io.github.tscholze.mpcsample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Suppress("FunctionName")
@Composable
internal fun RootContent() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
       Text("Greetings from shared!", modifier = Modifier.align(Alignment.Center))
    }
}