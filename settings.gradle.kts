pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "fit-app"
include(":app")
include(":core-model")
include(":feature-home")
include(":feature-exercises")
include(":feature-supplements")
include(":core-database")
include(":core-data")
include(":ui-common")
include(":feature-splash")
include(":feature-routines")
include(":core-navigation")
include(":feature-exercise")
include(":feature-routine")
include(":feature-supplement")
