package com.devtorres.core_navigation

sealed class Screen(val route: String) {
    data object HomeRoot : Screen("home")
    data object HomeSub: Screen("subHome")
    data object Exercises : Screen("exercises")
    data object Routines : Screen("routines")
    data object Supplements : Screen("supplements")

    data object Exercise : Screen("exercise/{exerciseId}") {
        private const val EXERCISE_BASE_ROUTE = "exercise"
        fun createRoute(id: String) = "${EXERCISE_BASE_ROUTE}/$id"
    }

    data object Supplement : Screen("supplement/{supplementId}") {
        private const val SUPPLEMENT_BASE_ROUTE = "supplement"
        fun createRoute(id: String) = "${SUPPLEMENT_BASE_ROUTE}/$id"
    }

    data object Routine : Screen("routine/{routineId}") {
        private const val ROUTINE_BASE_ROUTE = "routine"
        fun createRoute(id: String) = "${ROUTINE_BASE_ROUTE}/$id"
    }
}