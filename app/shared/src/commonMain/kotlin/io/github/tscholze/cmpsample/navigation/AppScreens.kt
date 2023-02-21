package io.github.tscholze.cmpsample.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.copperleaf.ballast.navigation.routing.Route
import com.copperleaf.ballast.navigation.routing.RouteAnnotation
import com.copperleaf.ballast.navigation.routing.RouteMatcher

/**
 * Based on https://copper-leaf.github.io/ballast/wiki/modules/ballast-navigation/
 */
enum class AppScreens(
    val title: String,
    val icon: ImageVector,
    routeFormat: String,
    override val annotations: Set<RouteAnnotation> = emptySet(),
) : Route {

    // MARK: - Screens -

    LocalData("Local data", Icons.Rounded.Home, "/app/local-data"),
    RemoteData("Remote data", Icons.Rounded.ThumbUp, "/app/remote-data"),
    OtherFeatures("Other features", Icons.Rounded.ExitToApp, "/app/other-features");

    // MARK: - Matcher -

    override val matcher: RouteMatcher = RouteMatcher.create(routeFormat)
}