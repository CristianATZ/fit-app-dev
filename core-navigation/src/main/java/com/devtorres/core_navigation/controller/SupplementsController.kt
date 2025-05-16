package com.devtorres.core_navigation.controller

import androidx.navigation.NavController
import com.devtorres.core_navigation.Screen

fun NavController.navigateToSupplements() {
    this.navigate(Screen.Supplements.route) {
        launchSingleTop = true
    }
}