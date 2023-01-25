package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// MARK: - Internal properties -

internal val SafeArea = compositionLocalOf { safeAreaState }
internal val safeAreaState = mutableStateOf(PaddingValues())

// MARK: - Composable -

/**
 * App-themed scaffold with a top and bottom bar.
 */
@Composable
internal fun CMPScaffold(content: @Composable () -> Unit) {

    // MARK: - Components -

    @Composable
    fun CMPAppBar() {
        TopAppBar(
            title = { Text(text = "Kennzeichner") }
        )
    }

    @Composable
    fun CMPBottomAppBar() {
        BottomAppBar {
            // Home
            BottomNavigationItem(
                icon = {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = "Home"
                    )
                },
                label = {
                    Text(
                        text = "Home",
                        fontSize = 9.sp
                    )
                },
                selected = true,
                onClick = {}
            )

            // About
            BottomNavigationItem(
                icon = {
                    Icon(
                        Icons.Rounded.Face,
                        contentDescription = "About"
                    )
                },
                label = {
                    Text(
                        text = "About",
                        fontSize = 9.sp
                    )
                },
                selected = false,
                onClick = {}
            )
        }
    }

    // MARK: - UI -

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
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