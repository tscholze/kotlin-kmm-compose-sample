package io.github.tscholze.cmpsample.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.navigation.AppScreens

@Composable
internal fun RemoteResourceScreen(router: Router<AppScreens>) {

    // MARK: - UI -

    return PageLayout("Remote Resources", router) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.error)) {
            Text("Remote", style = MaterialTheme.typography.h1)
        }
    }
}