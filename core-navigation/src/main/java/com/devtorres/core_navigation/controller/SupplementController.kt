package com.devtorres.core_navigation.controller

import androidx.navigation.NavController
import com.devtorres.core_navigation.Screen

fun NavController.navigateToSupplement(supplementId: String) {
    this.navigate(Screen.Supplement.createRoute(supplementId))
}