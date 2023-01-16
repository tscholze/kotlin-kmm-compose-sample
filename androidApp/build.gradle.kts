plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "io.github.tscholze.mpcsample.android"
    compileSdk = Configuration.Android.compile
    defaultConfig {
        applicationId = location(Modules.ANDROID)
        minSdk = Configuration.Android.min
        targetSdk = Configuration.Android.target
        versionCode = Configuration.Android.versionCode
        versionName = Configuration.Android.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")
}