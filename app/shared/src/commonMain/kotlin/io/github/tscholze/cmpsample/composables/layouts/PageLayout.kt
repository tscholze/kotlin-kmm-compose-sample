package io.github.tscholze.cmpsample.composables.layouts

import androidx.compose.runtime.Composable
import io.github.tscholze.cmpsample.composables.components.CMPScaffold
import io.github.tscholze.cmpsample.theme.CMPTheme

/**
 * Themed-styled layout for a full screen styled page.
 */
@Composable
internal fun PageLayout(content: @Composable () -> Unit) {
    CMPTheme {
        CMPScaffold {
            content()
        }
    }
}