package io.github.tscholze.cmpsample

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.github.tscholze.cmpsample.composables.layouts.PageLayout

@Composable
internal fun RootContent() {
    PageLayout {
        Text("Root")
        Text("Layout")
    }
}


