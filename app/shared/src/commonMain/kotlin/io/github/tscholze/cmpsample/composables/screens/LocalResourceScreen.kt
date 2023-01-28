package io.github.tscholze.cmpsample.composables.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.components.Banner
import io.github.tscholze.cmpsample.composables.components.SearchView
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.model.LicensePlateLocation
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.github.tscholze.cmpsample.utils.ResourceReader

@Composable
internal fun LocalResourceScreen(router: Router<AppScreens>) {

    // MARK: - Inner properties -

    val textState = remember { mutableStateOf("") }
    val allValues = parseData()

    // MARK: - Inner helper -

    fun filterPlates(query: String): List<LicensePlateLocation> {
        if (query.isEmpty()) {
            return allValues
        }

        return allValues.filter {
            it.id.startsWith(query, ignoreCase = true)
                    || it.state.startsWith(query, ignoreCase = true)
                    || it.state.startsWith(query, ignoreCase = true)
        }
    }

    // MARK: - UI -

    PageLayout("Local Resources", router) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            // 1. Info block
            Banner("The following data was fetched from a local file.")

                // 2. Search container
                SearchView(textState)

                // 3. List of filtered license plate locations
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(filterPlates(textState.value)) { row ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // ID like "A"
                            Text(row.id, style = MaterialTheme.typography.h3)

                            // City "Augsburg"
                            // State "Bayern"
                            Column(
                                horizontalAlignment = Alignment.End,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(row.city, modifier = Modifier.wrapContentWidth(Alignment.End))
                                Text(row.state, modifier = Modifier.wrapContentWidth(Alignment.End))
                            }
                        }
                }
            }
        }
    }
}

// MARK: - Private helper -

private fun parseData(): List<LicensePlateLocation> {
    // 1. Prepare raw data from CSV file.
    val rawData = ResourceReader()
        .readResource("data.csv")
        .lines()
        .drop(1)
        .map { it.split(",") }

    // 2. Parse given raw data into LicensePlateLocation objects.
    val plates = mutableListOf<LicensePlateLocation>()
    for (column in rawData) {
        // 2.1 Try to parse raw data
        try {
            // 2.1.1 Validate input.
            if (column.count() != 3) continue

            // 2.1.2 Add valid parsed locations to list
            plates.add(LicensePlateLocation(column[0], column[1], column[2]))
        } catch (e: Exception) {
            // 2.2 Catch and log all thrown exception
            println("Ignoring raw data column: $column")
        }
    }

    // Return found LicensePlateLocations
    return plates
}