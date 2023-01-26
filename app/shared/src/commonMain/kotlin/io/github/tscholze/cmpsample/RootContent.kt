package io.github.tscholze.cmpsample

import androidx.compose.runtime.*
import com.copperleaf.ballast.navigation.routing.Backstack
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.screens.LocalResourceScreen
import io.github.tscholze.cmpsample.composables.screens.RemoteResourceScreen
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.github.tscholze.cmpsample.navigation.RouterViewModel

/**
 * Entry point of the app.
 */
@Composable
internal fun RootContent() {

    // MARK: - Properties -

    val applicationScope = rememberCoroutineScope()
    val router: Router<AppScreens> = remember(applicationScope) { RouterViewModel(applicationScope) }
    val routerState: Backstack<AppScreens> by router.observeStates().collectAsState()

    // MARK: - Router -
    routerState.renderCurrentDestination(
        route = { appScreen: AppScreens ->
            when(appScreen) {
                AppScreens.LocalData -> LocalResourceScreen(router)
                AppScreens.RemoteData -> RemoteResourceScreen(router)
            }
        },
        notFound = { },
    )
}

