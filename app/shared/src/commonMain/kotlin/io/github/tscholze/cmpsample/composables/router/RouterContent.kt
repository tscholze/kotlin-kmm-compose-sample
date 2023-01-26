package io.github.tscholze.cmpsample.composables.router

import androidx.compose.runtime.*
import com.copperleaf.ballast.navigation.routing.*
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.screens.detail.LocalResourceDetainScreen
import io.github.tscholze.cmpsample.composables.screens.list.LocalResourceScreen

@Composable
internal fun RouterContent() {
    val applicationScope = rememberCoroutineScope()
    val router: Router<AppScreen> = remember(applicationScope) { RouterViewModel(applicationScope) }

    val routerState: Backstack<AppScreen> by router.observeStates().collectAsState()

    routerState.renderCurrentDestination(
        route = { appScreen: AppScreen ->
            when (appScreen) {
                AppScreen.LocalResourceList -> LocalResourceScreen(
                    onGoToLocalResourceDetail = { itemId ->
                        router.trySend(
                            RouterContract.Inputs.GoToDestination(
                                AppScreen.LocalResourceDetail
                                    .directions()
                                    .pathParameter("itemId", itemId)
                                    .build()
                            )
                        )
                    }
                )

                AppScreen.LocalResourceDetail -> {
                    val itemId: String by stringPath()

                    LocalResourceDetainScreen(
                        onGoBack = { router.trySend(RouterContract.Inputs.GoBack()) },
                        itemId = itemId
                    )
                }
            }
        },
        notFound = { },
    )
}
