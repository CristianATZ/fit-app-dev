package com.devtorres.core_navigation.controller

import androidx.navigation.NavController
import com.devtorres.core_navigation.Screen

fun NavController.navigateToRoutine(routineId: String) {
    this.navigate(Screen.Routine.createRoute(routineId)) {
        launchSingleTop = true
    }
}