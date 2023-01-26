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
import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.navigation.AppScreens

// MARK: - Internal properties -

internal val SafeArea = compositionLocalOf { safeAreaState }
internal val safeAreaState = mutableStateOf(PaddingValues())

// MARK: - Composable -

/**
 * App-themed scaffold with a top and bottom bar.
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
            // Home
            BottomNavigationItem(
                icon = {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = "Local Data"
                    )
                },
                label = {
                    Text(
                        text = "Local Data",
                        fontSize = 9.sp
                    )
                },
                selected = true,
                onClick = {
                    router.trySend(
                        RouterContract.Inputs.GoToDestination(AppScreens.LocalData.matcher.routeFormat)
                    )
                }
            )

            // About
            BottomNavigationItem(
                icon = {
                    Icon(
                        Icons.Rounded.Face,
                        contentDescription = "Remote Data"
                    )
                },
                label = {
                    Text(
                        text = "Remote Data",
                        fontSize = 9.sp
                    )
                },
                selected = false,
                onClick = {
                    router.trySend(
                        RouterContract.Inputs.GoToDestination(AppScreens.RemoteData.matcher.routeFormat)
                    )
                }
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