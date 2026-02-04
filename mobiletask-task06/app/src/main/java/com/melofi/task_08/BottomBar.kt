package com.melofi.task_08

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
@Composable
fun BottomBar(navController: NavHostController) {

    val currentRoute =
        navController.currentBackStackEntryAsState().value
            ?.destination?.route

    val destinations = listOf(
        Destination.Home,
        Destination.Search,
        Destination.Playlists
    )

    NavigationBar(
        containerColor = Color(0xFF9B7A5B),
    ) {

        destinations.forEach { destination ->

            NavigationBarItem(

                selected = currentRoute == destination.route,

                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.label
                    )
                },

                label = {
                    Text(destination.label)
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}
