package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
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
    content: @Composable () -> Unit) {

    // MARK: - Components -

    @Composable
    fun CMPAppBar() {
        TopAppBar(
            title = { Text(title) }
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
                            fontSize = 9.sp
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