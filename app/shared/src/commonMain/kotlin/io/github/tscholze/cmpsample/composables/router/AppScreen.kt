package io.github.tscholze.cmpsample.composables.router

import com.copperleaf.ballast.navigation.routing.Route
import com.copperleaf.ballast.navigation.routing.RouteAnnotation
import com.copperleaf.ballast.navigation.routing.RouteMatcher

enum class AppScreen(
    routeFormat: String,
    override val annotations: Set<RouteAnnotation> = emptySet(),
) : Route {
    LocalResourceList("/app/list"),
    LocalResourceDetail("/app/list/{postId}"),
    ;

    override val matcher: RouteMatcher = RouteMatcher.create(routeFormat)
}
