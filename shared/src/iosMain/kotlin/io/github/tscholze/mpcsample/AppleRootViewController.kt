package io.github.tscholze.mpcsample
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import kotlinx.cinterop.useContents
import platform.UIKit.UIViewController
import platform.UIKit.UIWindow

@Suppress("FunctionName", "unused") // Used in ios
fun AppleRootViewController() {
    Application("MCP Sample") {
        RootContent()
    }
}

@Suppress("FunctionName", "unused") // Used in iOS
fun MainViewController(window: UIWindow): UIViewController {
    return Application("MCP Sample") {

        val rememberedComposeWindow by remember(window) {
            val windowInfo = window.frame.useContents {
                WindowInfo(this.size.width.dp, this.size.height.dp)
            }
            mutableStateOf(windowInfo)
        }

        CompositionLocalProvider(
            LocalWindow provides rememberedComposeWindow
        ) {
            MCPSampleTheme {
                Column {
                    Box(Modifier.height(48.dp)
                        .background(color = androidx.compose.ui.graphics.Color.White)
                    )
                    RootContent()
                }
            }
        }
    }
}