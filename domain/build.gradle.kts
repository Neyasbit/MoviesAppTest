import com.example.buildsrc.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = com.example.buildsrc.AppConfig.compileSdk
    defaultConfig {
        minSdk = com.example.buildsrc.AppConfig.minSdk
        targetSdk = com.example.buildsrc.AppConfig.targetSdk
    }
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation(Libs.Hilt.hilt_android)
    kapt(Libs.Hilt.hilt_compiler)
}
