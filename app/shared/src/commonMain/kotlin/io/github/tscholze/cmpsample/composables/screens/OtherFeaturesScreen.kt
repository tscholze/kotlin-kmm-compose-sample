package io.github.tscholze.cmpsample.composables.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.components.Banner
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.github.tscholze.cmpsample.utils.UserPreferenceReader

/**
 * Sample screen to demonstrate different bunch of features.
 */
@Composable
internal fun OtherFeaturesScreen(router: Router<AppScreens>) {

    // MARK - Private properties -

    val userPreferenceReader = UserPreferenceReader()
    val state = mutableStateOf(userPreferenceReader.readString("sampleText"))

    LaunchedEffect(AppScreens.OtherFeatures.matcher.path) {
        state.value = userPreferenceReader.readString("sampleText")
    }

    // MARK: - UI -

    PageLayout(AppScreens.LocalData.title, router) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // 1. Info block
            Banner("Showcases other features that are often used.")

            // 2. List of features
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

               // 2.1 User preferences
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        "User preferences",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Persisted store of values in user's preferences")

                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Text that shall be persisted") },
                        singleLine = true,
                        value = state.value ?: "",
                        onValueChange = {
                            state.value = it
                            userPreferenceReader.storeString("sampleText", it)
                        }
                    )
                }
            }
        }
    }
}