package io.github.tscholze.cmpsample

import androidx.compose.ui.window.Application
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused") // Used in iOS
fun RootViewController(): UIViewController {
    return Application("CMP Sample") {
        RootContent()
    }
}