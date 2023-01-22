package io.github.tscholze.cmpsample

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

internal val safeAreaState = mutableStateOf(PaddingValues())
internal val SafeArea = compositionLocalOf { safeAreaState }

@Composable
internal fun RootContent(modifier: Modifier = Modifier) {
    MyApplicationTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier.padding(
                    start = SafeArea.current.value.calculateStartPadding(LayoutDirection.Ltr),
                    top = SafeArea.current.value.calculateTopPadding(),
                    end = SafeArea.current.value.calculateEndPadding(LayoutDirection.Ltr),
                    bottom = SafeArea.current.value.calculateBottomPadding()
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        "Thanks Adrian and David!",
                        style = MaterialTheme.typography.h3
                    )

                    Text(
                        text = "Hello from the shared Compose world!",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}