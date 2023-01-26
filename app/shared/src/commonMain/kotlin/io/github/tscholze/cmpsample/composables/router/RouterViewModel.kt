package io.github.tscholze.cmpsample.composables.router

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.ExperimentalBallastApi
import com.copperleaf.ballast.build
import com.copperleaf.ballast.eventHandler
import com.copperleaf.ballast.navigation.routing.RoutingTable
import com.copperleaf.ballast.navigation.routing.fromEnum
import com.copperleaf.ballast.navigation.vm.BasicRouter
import com.copperleaf.ballast.navigation.vm.withRouter
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalBallastApi::class)
class RouterViewModel(
    viewModelCoroutineScope: CoroutineScope,
) : BasicRouter<AppScreen>(
    config = BallastViewModelConfiguration.Builder()
        .withRouter(
            routingTable = RoutingTable.fromEnum(AppScreen.values()),
            initialRoute = AppScreen.LocalResourceList,
        )
        .build(),
    eventHandler = eventHandler { },
    coroutineScope = viewModelCoroutineScope,
)
