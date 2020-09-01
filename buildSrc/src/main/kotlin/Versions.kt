object Deps {

    object Androidx {
        const val material = "com.google.android.material:material:1.1.0"
        const val core = "androidx.core:core-ktx:1.2.0"
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val activity = "androidx.activity:activity-ktx:1.1.0"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
        const val navFrag = "androidx.navigation:navigation-fragment-ktx:${PluginVersions.nav}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val testRules = "androidx.test:rules:${Versions.androidTest}"
        const val testRunner = "androidx.test:runner:${Versions.androidTest}"
        const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
    }

    object Square {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
        const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverterMoshi =
            "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Koin {
        const val core = "org.koin:koin-android:${Versions.koin}"
        const val test = "org.koin:koin-test:${Versions.koin}"
        const val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
        const val fragment = "org.koin:koin-androidx-fragment:${Versions.koin}"
    }

    object Kotlin {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val coil = "io.coil-kt:coil:${Versions.coil}"
        const val coilSvg = "io.coil-kt:coil-svg:${Versions.coil}"
    }

    object View {
        const val scrollView = "com.yarolegovich:discrete-scrollview:1.5.1"
    }

    object Test {
        const val junit = "junit:junit:4.12"
    }
}

object PluginVersions {
    const val kotlin = "1.3.71"
    const val nav = "2.2.1"
    const val koin = Versions.koin
    const val realm = "6.0.2"
}

object AndroidConfig {
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 21
}

/**
 * Version substrings for dependencies with multiple artifacts.
 *
 * When a dependency is made up of multiple artifacts whose versions are tied together then it
 * makes sense to deduplicate the version part of the dependency string into [Versions]. This way we
 * are sure that those artifacts are always updated together and their versions will not go "out of
 * sync".
 */
private object Versions {
    const val moshi = "1.9.2"
    const val okhttp = "4.4.1"
    const val retrofit = "2.8.1"
    const val fragment = "1.2.3"
    const val koin = "2.1.5"
    const val coil = "0.11.0"
    const val coroutines = "1.3.6"
    const val androidTest = "1.2.0"
}
