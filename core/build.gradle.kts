import com.example.buildsrc.AppConfig
import com.example.buildsrc.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
    api(project(":navigation"))
    api(project(":domain"))
    api(Libs.Core.coreKtx)
    api(Libs.Core.appCompat)
    api(Libs.Core.material)
    api(Libs.Timber.timber)
    api(Libs.Network.glide)

    implementation(Libs.Moxy.moxyAndroidX)
    kapt(Libs.Moxy.moxy_compiler)
}
