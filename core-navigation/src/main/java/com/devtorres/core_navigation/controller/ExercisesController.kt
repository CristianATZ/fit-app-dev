package com.devtorres.core_navigation.controller

import androidx.navigation.NavController
import com.devtorres.core_navigation.Screen

fun NavController.navigateToExercises() {
    this.navigate(Screen.Exercises.route) {
        launchSingleTop = true
    }
}