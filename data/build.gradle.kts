import com.example.buildsrc.AppConfig
import com.example.buildsrc.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}
dependencies {
    implementation(project(":domain"))
    implementation(Libs.OkHttp.okHttp)
    implementation(Libs.OkHttp.okHttpLoggingInterceptor)
    implementation(Libs.Network.kotlinxSerializationJson)
    api(Libs.Network.retrofit)
    implementation(Libs.Network.retrofitKotlinxConverter)


    implementation(Libs.Coroutines.kotlinCoroutinesAndroid)
    implementation(Libs.Room.room)
    implementation(Libs.Room.roomKtx)
    kapt(Libs.Room.roomCompiler)

    implementation(Libs.Hilt.hilt_android)
    kapt(Libs.Hilt.hilt_compiler)

}


