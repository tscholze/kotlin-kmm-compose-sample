package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * A simple banner that renders the given text
 *
 * @param text Text that should be rendered.
 */
@Composable
internal fun Banner(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
        )
    }
}