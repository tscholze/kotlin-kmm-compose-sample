object Version {
    const val activity = "1.6.1"
    const val coroutines = "1.6.4"
    const val kotlin = "1.7.20"
    const val material = "1.4.0"
    const val jetbrainsCompose = "1.2.1"
    const val jetpackCompose = "1.2.1"
}

object JetpackCompose {
    const val activity = "androidx.activity:activity-compose:${Version.activity}"
    const val runtime = "androidx.compose.runtime:runtime:${Version.jetpackCompose}"
    const val ui = "androidx.compose.ui:ui:${Version.jetpackCompose}"
    const val foundationLayout =
        "androidx.compose.foundation:foundation-layout:${Version.jetpackCompose}"
    const val material = "androidx.compose.material:material:${Version.jetpackCompose}"
}

object Kotlin {
    const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
}