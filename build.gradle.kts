buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${com.example.buildsrc.Libs.Navigation.nav_version}")
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}