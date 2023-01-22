package io.github.tscholze.cmpsample.composables.layouts

import androidx.compose.runtime.Composable
import io.github.tscholze.cmpsample.MyApplicationTheme
import io.github.tscholze.cmpsample.composables.components.CMPScaffold

@Composable
fun PageLayout(content: @Composable () -> Unit) {
    MyApplicationTheme {
        CMPScaffold {
            content()
        }
    }
}