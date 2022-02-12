import com.example.buildsrc.AppConfig
import com.example.buildsrc.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    api(Libs.Navigation.navigationFragment)
    api(Libs.Navigation.navigationUi)
}
