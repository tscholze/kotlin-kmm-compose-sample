package io.github.tscholze.cmpsample

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun RootContent(modifier: Modifier = Modifier) {
    MyApplicationTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(
                contentAlignment = Alignment.TopStart,
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Hello world",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(32.dp)
                    )
                }
            }
        }
    }
}