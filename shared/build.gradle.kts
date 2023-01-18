plugins {
    kotlin(Plugins.KOTLIN_MULTIPLATFORM)
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.JETBRAINS_COMPOSE) version Version.jetbrainsCompose
}

version = Configuration.Kotlin.version

kotlin {
    android()
    
    listOf(
       // iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.all {
            freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                with(compose) {
                    implementation(ui)
                    implementation(animation)
                    implementation(animationGraphics)
                    implementation(foundation)
                    implementation(material)
                    implementation(runtime)
                }
            }
        }

        val androidMain by getting {
            dependencies {
                with(JetpackCompose) {
                    api(activity)
                    implementation(runtime)
                    implementation(ui)
                    implementation(foundationLayout)
                    implementation(material)
                }
            }
        }
    }
}

android {
    namespace = Configuration.Android.id
    compileSdk = Configuration.Android.compile
    defaultConfig {
        minSdk = Configuration.Android.min
        targetSdk = Configuration.Android.target
    }
}

dependencies {
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.2")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.2")
}