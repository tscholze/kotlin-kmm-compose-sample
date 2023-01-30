package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.navigation.AppScreens

// MARK: - Internal properties -

internal val SafeArea = compositionLocalOf { safeAreaState }
internal val safeAreaState = mutableStateOf(PaddingValues())

// MARK: - Composable -

/**
 * App-themed scaffold with a top and bottom bar.
 *
 * Caution:
 *  The title has to be the same as for the AppScreen.*
 *  value. This is used to mark the tab item as selected.
 *
 * @param title Title of the screen
 * @param router that shall be used
 * @param content Content of the scaffold
 */
@Composable
internal fun CMPScaffold(
    title: String,
    router: Router<AppScreens>,
    content: @Composable () -> Unit
) {
    // MARK: - Helper -

    val uriHandler = LocalUriHandler.current

    // MARK: - Components -

    @Composable
    fun CMPAppBar() {
        TopAppBar(
            title = { Text(title) },
            actions = {
                Button(
                    onClick = {
                        uriHandler.openUri("https://github.com/tscholze/kotlin-kmm-compose-sample")
                    },
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Visit me on GitHub")
                        Icon(
                            Icons.Rounded.Face,
                            contentDescription = "Go to GitHub"
                        )
                    }

                }
            }
        )
    }

    @Composable
    fun CMPBottomAppBar() {
        BottomAppBar {
            AppScreens.values().forEach { screen ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            screen.icon,
                            contentDescription = screen.title
                        )
                    },
                    label = {
                        Text(
                            text = screen.title,
                            fontSize = 10.sp
                        )
                    },
                    selected = title == screen.title,
                    onClick = {
                        router.trySend(
                            RouterContract.Inputs.GoToDestination(screen.matcher.routeFormat)
                        )
                    }
                )
            }
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
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                content()
            }
        }
    }
}