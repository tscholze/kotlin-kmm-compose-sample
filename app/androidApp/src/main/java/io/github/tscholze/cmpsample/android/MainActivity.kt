package io.github.tscholze.cmpsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.tscholze.cmpsample.AndroidRootContent
import io.github.tscholze.cmpsample.utils.Android

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Android.context = this

        setContent {
            AndroidRootContent()
        }
    }
}