import com.example.buildsrc.AppConfig
import com.example.buildsrc.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
    api(project(":core"))

    implementation(Libs.Hilt.hilt_android)
    kapt(Libs.Hilt.hilt_compiler)

    implementation(Libs.Moxy.moxyAndroidX)
    implementation(Libs.Moxy.moxyKtx)
    kapt(Libs.Moxy.moxy_compiler)

    implementation(Libs.AdapterDelegates.viewBinding)
    implementation(Libs.AdapterDelegates.lib)
}