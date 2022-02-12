
import com.example.buildsrc.AppConfig
import com.example.buildsrc.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
kapt {
    correctErrorTypes = true
}
android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
        }
        debug {
            isDebuggable = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguardOptimize),
                AppConfig.proguardRulesPro
            )
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }

}

dependencies {
    implementation(project(":data"))
    implementation(project(":ui-search-feature"))
    implementation(project(":ui-detail-feature"))

    implementation(Libs.Hilt.hilt_android)
    kapt(Libs.Hilt.hilt_compiler)

    implementation(Libs.Navigation.navigationFragment)
    implementation(Libs.Navigation.navigationUi)
}
