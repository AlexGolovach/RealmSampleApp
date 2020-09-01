plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    defaultConfig {
        minSdkVersion(AndroidConfig.minSdkVersion)
    }
}

dependencies {
    implementation(project(":database"))
    implementation(Deps.Square.okhttp)
    implementation(Deps.Square.retrofit)
    implementation(Deps.Square.retrofitConverterMoshi)
    implementation(Deps.Square.moshi)
    implementation(Deps.Square.moshiAdapters)
    implementation(Deps.Koin.core)
    implementation(Deps.Kotlin.coroutines)
    kapt(Deps.Square.moshiKotlinCodegen)
}
