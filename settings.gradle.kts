pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application" -> useModule("com.android.tools.build:gradle:${requested.version}")
                "androidx.navigation.safeargs.kotlin" -> useModule("androidx.navigation:navigation-safe-args-gradle-plugin:${requested.version}")
                "koin" -> useModule("org.koin:koin-gradle-plugin:${requested.version}")
                "realm-android" -> useModule("io.realm:realm-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "RealmSampleApp"

include(
    ":app",
    ":countries",
    ":common",
    ":database",
    ":ui"
)