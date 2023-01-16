package io.github.tscholze.mpcsample

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup window.
        window.decorView.setBackgroundColor(Color.WHITE)
        window.statusBarColor = Color.parseColor("#cc7000")

        // Setup content
        setContent {
            RootContent()
        }
    }
}