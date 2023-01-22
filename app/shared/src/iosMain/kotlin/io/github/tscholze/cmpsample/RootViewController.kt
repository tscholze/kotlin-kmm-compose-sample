package io.github.tscholze.cmpsample

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import io.github.tscholze.cmpsample.composables.components.safeAreaState
import platform.CoreGraphics.CGFloat
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused") // Used in iOS
fun RootViewController(): UIViewController {
    return Application("CMP Sample") {
        RootContent()
    }
}

@Suppress("unused") // Used in iOS
fun setSafeArea(start: CGFloat, top: CGFloat, end: CGFloat, bottom: CGFloat) {
    safeAreaState.value = PaddingValues(start.dp, top.dp, end.dp, bottom.dp)
}