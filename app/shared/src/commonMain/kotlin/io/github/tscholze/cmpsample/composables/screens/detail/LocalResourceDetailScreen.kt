package io.github.tscholze.cmpsample.composables.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun LocalResourceDetainScreen(
    onGoBack: () -> Unit,
    itemId: String,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("LocalResourceDetainScreen")
            Text("itemId = $itemId")
            Spacer(modifier = Modifier.size(24.dp))
            Button(
                onClick = onGoBack
            ) {
                Text("Go back")
            }
        }
    }
}
