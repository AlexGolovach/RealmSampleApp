plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":common"))
    implementation(Deps.Androidx.material)
    implementation(Deps.Androidx.fragment)
    implementation(Deps.Androidx.constraintlayout)
    implementation(Deps.View.scrollView)
    implementation(Deps.Koin.viewModel)

}