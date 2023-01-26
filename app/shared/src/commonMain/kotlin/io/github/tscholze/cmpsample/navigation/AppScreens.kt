package io.github.tscholze.cmpsample.navigation

import com.copperleaf.ballast.navigation.routing.Route
import com.copperleaf.ballast.navigation.routing.RouteAnnotation
import com.copperleaf.ballast.navigation.routing.RouteMatcher

/**
 * Based on https://copper-leaf.github.io/ballast/wiki/modules/ballast-navigation/
 */
enum class AppScreens(
    routeFormat: String,
    override val annotations: Set<RouteAnnotation> = emptySet(),
) : Route {

    // MARK: - Screens -

    LocalData("/app/local-data"),
    RemoteData("/app/remote-data");

    // MARK: - Matcher -

    override val matcher: RouteMatcher = RouteMatcher.create(routeFormat)
}