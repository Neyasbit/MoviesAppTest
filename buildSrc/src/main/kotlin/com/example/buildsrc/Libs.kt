package com.example.buildsrc

object Libs {

    object Core {
        private const val core_ktx = "1.3.2"
        private const val app_compat_version = "1.2.0"
        private const val material_version = "1.3.0"
        private const val recyclerViewVersion = "1.1.0"

        const val coreKtx = "androidx.core:core-ktx:$core_ktx"
        const val appCompat = "androidx.appcompat:appcompat:$app_compat_version"
        const val material = "com.google.android.material:material:$material_version"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"

        const val supportActivity = "androidx.activity:activity-ktx:1.4.0"
        const val supportFragment = "androidx.fragment:fragment-ktx:1.4.0"
        const val supportPreferences = "androidx.preference:preference-ktx:1.1.1"
        const val supportAnnotations = "androidx.annotation:annotation:1.1.0"

    }

    object Navigation {
        const val nav_version = "2.4.0-rc01"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$nav_version"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$nav_version"
    }

    object Coroutines {
        private const val coroutinesVersion = "1.5.1"

        const val kotlinCoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val kotlinCoroutinesRx2 =
            "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$coroutinesVersion"
        const val kotlinCoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    }

    // Dagger - Hilt
    object Hilt {
        private const val hiltVersion = "2.40.5"
        const val hilt_android = "com.google.dagger:hilt-android:$hiltVersion"
        const val hilt_compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
        const val hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    }

    object Network {
        private const val kotlinxSerializationVersion = "1.1.0"
        private const val retrofitKotlinxConverterVersion = "0.8.0"
        private const val retrofitVersion = "2.9.0"
        private const val glideVersion = "4.11.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val gson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val kotlinxSerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion"
        const val retrofitKotlinxConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofitKotlinxConverterVersion"
        const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    }

    object OkHttp {
        private const val okhttp3Version = "4.9.1"
        const val okHttp = "com.squareup.okhttp3:okhttp:$okhttp3Version"
        const val okHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:$okhttp3Version"
    }

    object Room {
        private const val room_version = "2.4.1"
        const val room = "androidx.room:room-runtime:$room_version"
        const val roomKtx = "androidx.room:room-ktx:$room_version"
        const val roomCompiler = "androidx.room:room-compiler:$room_version"
    }

    object Moxy {
        private const val moxy_version = "2.2.2"
        const val moxyAndroidX = "com.github.moxy-community:moxy-androidx:$moxy_version"
        const val moxy_compiler = "com.github.moxy-community:moxy-compiler:$moxy_version"
        const val moxyKtx = "com.github.moxy-community:moxy-ktx:$moxy_version"
    }
    object Timber {
        private const val timber_version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:$timber_version"
    }
    object AdapterDelegates {
        private const val version = "4.3.1"
        const val viewBinding = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:$version"
        const val lib = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$version"
    }
}
