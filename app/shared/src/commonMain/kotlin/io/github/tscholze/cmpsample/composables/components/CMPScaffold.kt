package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

// MARK: - Internal properties -

internal val safeAreaState = mutableStateOf(PaddingValues())
internal val SafeArea = compositionLocalOf { safeAreaState }

// MARK: - Composable -

@Composable
internal fun CMPScaffold(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary) // Whatever colour you want
    ) {
        Scaffold(
            topBar = { CMPAppBar() },
            bottomBar = { CMPBottomAppBar() },
            modifier = Modifier.padding(
                start = SafeArea.current.value.calculateStartPadding(LayoutDirection.Ltr),
                top = SafeArea.current.value.calculateTopPadding(),
                end = SafeArea.current.value.calculateEndPadding(LayoutDirection.Ltr),
                bottom = SafeArea.current.value.calculateBottomPadding()
            ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                content()
            }
        }
    }
}