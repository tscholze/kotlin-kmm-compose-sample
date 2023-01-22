package io.github.tscholze.cmpsample

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.tscholze.cmpsample.composables.layouts.PageLayout

@Composable
internal fun RootContent(modifier: Modifier = Modifier) {
    PageLayout {
        Text("Root")
        Text("Layout")
    }
}


