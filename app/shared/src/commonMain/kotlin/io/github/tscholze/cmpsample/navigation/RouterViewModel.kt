package io.github.tscholze.cmpsample.navigation

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.eventHandler
import com.copperleaf.ballast.navigation.routing.RoutingTable
import com.copperleaf.ballast.navigation.routing.fromEnum
import com.copperleaf.ballast.navigation.vm.BasicRouter
import com.copperleaf.ballast.navigation.vm.withRouter
import kotlinx.coroutines.CoroutineScope

class RouterViewModel(
    viewModelCoroutineScope: CoroutineScope
) : BasicRouter<AppScreens>(
    config = BallastViewModelConfiguration.Builder()
        .withRouter(RoutingTable.fromEnum(AppScreens.values()), AppScreens.LocalData)
        .build(),
    eventHandler = eventHandler { },
    coroutineScope = viewModelCoroutineScope,
)