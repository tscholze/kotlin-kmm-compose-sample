package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
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
 * Based on: https://johncodeos.com/how-to-add-search-in-list-with-jetpack-compose/
 */
@Composable
internal fun SearchView(state: MutableState<String>) {
    TextField(
        modifier = Modifier1.fillMaxWidth(),
        textStyle = TextStyle(color = MaterialTheme.colors.onBackground, fontSize = 18.sp),
        singleLine = true,
        value = state.value,
        onValueChange = { state.value = it  },
        leadingIcon = { LeadingIcon() },
        trailingIcon = { TrailingIcon(state) }
    )
}

@Composable
internal fun LeadingIcon() {
    Icon(
        Icons.Default.Search,
        contentDescription = "Search icon",
        modifier = Modifier1.padding(15.dp).size(24.dp)
    )
}

@Composable
internal fun TrailingIcon(state: MutableState<String>) {
    if (state.value != "") {
        IconButton(
            onClick = { state.value = "" }
        ) {
            Icon(
                Icons.Default.Close,
                contentDescription = "",
                modifier = Modifier1.padding(15.dp).size(24.dp)
            )
        }
    }
}