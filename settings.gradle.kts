pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Movies App"
include (":app")
include(":navigation")

include(":ui-search-feature")
include(":core")
include(":ui-detail-feature")
include(":data")
include(":domain")
