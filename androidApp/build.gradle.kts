plugins {
    id(Plugins.ANDROID_APP)
    id(Plugins.KOTLIN_ANDROID)
}

android {
    namespace = location(Modules.ANDROID)
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
    compileOptions {
        sourceCompatibility = Configuration.Kotlin.javaVersion
        targetCompatibility = Configuration.Kotlin.javaVersion
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
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
    with(JetpackCompose) {
        api(activity)
        implementation(runtime)
        implementation(ui)
        implementation(foundationLayout)
        implementation(material)
    }
}