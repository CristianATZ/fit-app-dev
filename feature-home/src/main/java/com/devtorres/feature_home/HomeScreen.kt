package com.devtorres.feature_home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.BatterySaver
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_home.nav.HomeNavigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private data class DrawerMenu(
    val icon: ImageVector,
    @StringRes val title: Int,
    val route: String,
    val containerColor: Color,
    val contentColor: Color
)

@Composable
private fun DrawerContent(
    onClick: (String) -> Unit,
    navController: NavHostController
) {
    val navCurrentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navCurrentBackStackEntry.value?.destination?.route

    val colors = colorScheme

    val menus = remember(colors) {
        listOf(
            DrawerMenu(Icons.Default.Home, R.string.lblHome, Screen.HomeSub.route, colors.background, colors.onBackground),
            DrawerMenu(Icons.Default.Bookmark, R.string.lblRoutines, Screen.Routines.route, colors.primary, colors.onPrimary),
            DrawerMenu(Icons.Default.BarChart, R.string.lblExercises, Screen.Exercises.route, colors.secondary, colors.onSecondary),
            DrawerMenu(Icons.Default.BatterySaver, R.string.lblSupplements, Screen.Supplements.route, colors.tertiary, colors.onTertiary)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        menus.forEach {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = stringResource(it.title)
                    )
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = null
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = it.containerColor,
                    selectedIconColor = it.contentColor,
                    selectedTextColor = it.contentColor
                ),
                selected = currentRoute == it.route,
                shape = shapes.medium,
                onClick = {
                    onClick(it.route)
                }
            )
        }
    }
}

@Composable
internal fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit,
    onNavigateToRoutine: () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    navController = navController,
                    onClick = { route ->
                        coroutineScope.launch {
                            drawerState.close()
                        }

                        navController.navigate(route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) {
        HomeNavigation(
            navController = navController,
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise,
            onNavigateToSupplement = onNavigateToSupplement,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}