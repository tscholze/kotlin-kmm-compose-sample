package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier as Modifier1

/**
 * Generic text query search view.
 *
 * Based on:
 * https://johncodeos.com/how-to-add-search-in-list-with-jetpack-compose/
 *
 * @param state Mutable state string that contains the typed query.
 */
@Composable
internal fun SearchView(state: MutableState<String>) {

    // MARK: - Components -
    
    @Composable
    fun LeadingIcon() {
        Icon(
            Icons.Default.Search,
            contentDescription = "Search icon",
            modifier = Modifier1.padding(15.dp).size(24.dp)
        )
    }

    @Composable
    fun TrailingIcon(state: MutableState<String>) {
        if (state.value != "") {
            IconButton(
                onClick = { state.value = "" }
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Clear icon",
                    modifier = Modifier1.padding(15.dp).size(24.dp)
                )
            }
        }
    }

    // MARK: - UI -

    TextField(
        modifier = Modifier1.fillMaxWidth(),
        textStyle = TextStyle(color = MaterialTheme.colors.onBackground, fontSize = 18.sp),
        placeholder = { Text("Suche nach Kennzeichen") },
        singleLine = true,
        value = state.value,
        onValueChange = { state.value = it  },
        leadingIcon = { LeadingIcon() },
        trailingIcon = { TrailingIcon(state) }
    )
}