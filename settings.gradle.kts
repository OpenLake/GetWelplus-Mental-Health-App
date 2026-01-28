pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }

    }
}

rootProject.name = "GetWell+"
include(":app")
include(":core:common")
include(":core:ui")
include(":core:data")
include(":feature:onboarding")
include(":feature:auth")
include(":feature:home")
include(":feature:settings")
include(":feature:resources")
include(":feature:profile")
include(":feature:chatbot")
include(":feature:stress")
include(":feature:relax")
 
