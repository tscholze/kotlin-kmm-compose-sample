package io.github.tscholze.cmpsample.composables.components

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
internal fun CMPBottomAppBar() {
    BottomAppBar {
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text(
                    text = "Home",
                    fontSize = 9.sp
                )
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Rounded.Face,
                    contentDescription = "About"
                )
            },
            label = {
                Text(
                    text = "About",
                    fontSize = 9.sp
                )
            },
            selected = false,
            onClick = {}
        )
    }
}