plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("realm-android")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    defaultConfig {
        minSdkVersion(AndroidConfig.minSdkVersion)
    }
}

dependencies {
    implementation(Deps.Koin.core)
    implementation(Deps.Kotlin.coroutines)
}