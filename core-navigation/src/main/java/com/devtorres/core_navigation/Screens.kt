package com.devtorres.core_navigation

sealed class Screen(val route: String) {
    data object HomeRoot : Screen("home")
    data object HomeSub: Screen("subHome")
    data object Exercises : Screen("exercises")
    data object Routines : Screen("routines")
    data object Supplements : Screen("supplements")

    data object Exercise : Screen("exercise/{exerciseId}") {
        fun createRoute(id: String) = "${this.route}/$id"
    }

    data object Supplement : Screen("supplement/{supplementId}") {
        fun createRoute(id: String) = "${this.route}/$id"
    }

    data object Routine : Screen("routine/{routineId}") {
        fun createRoute(id: String) = "${this.route}/$id"
    }
}