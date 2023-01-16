import org.gradle.api.JavaVersion

object Configuration {

    // MARK: - Android -

    object Android {
        const val id = "io.tscholze.mcpsample"
        const val min = 21
        const val compile = 33
        const val target = compile
        const val versionCode = 1
        const val versionName = "1.0"
    }

    // MARK: - iOS -

    object iOS {
        const val deploymentTarget = "16.0"
    }

    // MARK: - Kotlin -
    object Kotlin {
        const val version = "0.0.1"
        const val jvmTarget = "11"
        val javaVersion = JavaVersion.VERSION_11
    }
}

