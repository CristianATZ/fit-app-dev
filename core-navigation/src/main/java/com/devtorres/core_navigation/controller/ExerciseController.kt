package com.devtorres.core_navigation.controller

import androidx.navigation.NavController
import com.devtorres.core_navigation.Screen

fun NavController.navigateToExercise(exerciseId: String) {
    this.navigate(Screen.Exercise.createRoute(exerciseId)) {
        launchSingleTop = true
    }
}