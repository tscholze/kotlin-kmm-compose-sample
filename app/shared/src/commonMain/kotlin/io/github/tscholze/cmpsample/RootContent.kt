package io.github.tscholze.cmpsample

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.utils.ResourceReader

@Composable
internal fun RootContent() {
    PageLayout {
        Text("Root")
        Text("Layout")
    }
}

private fun parseData() {
    val csvString = ResourceReader().readResource("data.csv")
}
