package io.github.tscholze.cmpsample.composables.layouts

import androidx.compose.runtime.Composable
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.components.CMPScaffold
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.github.tscholze.cmpsample.theme.CMPTheme

/**
 * Themed-styled layout for a full screen styled page.
 */
@Composable
internal fun PageLayout(title: String, router: Router<AppScreens>, content: @Composable () -> Unit) {
    CMPTheme {
        CMPScaffold(title, router) {
            content()
        }
    }
}