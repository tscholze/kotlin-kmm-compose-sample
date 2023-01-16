package io.github.tscholze.mpcsample

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSize { Compact, Medium, Expanded }

fun getWindowSizeClass(windowWidth: Dp): WindowSize = when {
    windowWidth < 0.dp -> throw IllegalArgumentException("Dp value cannot be negative")
    windowWidth < 600.dp -> WindowSize.Compact
    windowWidth < 840.dp -> WindowSize.Medium
    else -> WindowSize.Expanded
}

data class WindowInfo(val width: Dp, val height: Dp, val minDimen: Dp? = null, val maxDimen: Dp? = null)

internal val LocalWindow = compositionLocalOf { WindowInfo(Dp.Unspecified, Dp.Unspecified) }