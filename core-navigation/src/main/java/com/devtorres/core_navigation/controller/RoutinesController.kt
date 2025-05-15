package com.devtorres.core_navigation.controller

import androidx.navigation.NavController
import com.devtorres.core_navigation.Screen

fun NavController.navigateToRoutines() {
    this.navigate(Screen.Routines.route)
}