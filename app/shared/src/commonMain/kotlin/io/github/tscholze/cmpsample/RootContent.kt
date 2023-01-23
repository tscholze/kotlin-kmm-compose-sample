package io.github.tscholze.cmpsample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.utils.ResourceReader

@Composable
internal fun RootContent() {
    PageLayout {
        LazyColumn {
            items(parseData()) { row ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // ID like "A"
                    Text(row.id, style = MaterialTheme.typography.h3)

                    // City "Augsburg"
                    // State "Bayern"
                    Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize()) {
                        Text(row.city, modifier = Modifier.wrapContentWidth(Alignment.End))
                        Text(row.state, modifier = Modifier.wrapContentWidth(Alignment.End))
                    }
                }
            }
        }
    }
}

private fun parseData(): List<LicensePlateLocation> {
    val rawData = ResourceReader()
        .readResource("data.csv")
        .split("\r\n")
        .drop(1)
        .map { it.split(",") }

    val plates = mutableListOf<LicensePlateLocation>()
    for (column in rawData) {
        try {
            if(column.count() != 3) continue
            plates.add(LicensePlateLocation(column[0], column[1], column[2]))
        } catch (e: Exception) {
            println("Ignoring raw data column: $column")
        }
    }

    return plates
}

data class LicensePlateLocation(
    val id: String,
    val city: String,
    val state: String
)