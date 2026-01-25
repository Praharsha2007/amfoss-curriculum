package com.melofi.task_08

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController) {

    NavigationBar(
        containerColor = Color(0xFF9B7A5B),
    ) {

        // Get current route (which screen is open)
        val currentRoute =
            navController.currentBackStackEntryAsState().value
                ?.destination?.route

        Destination.entries.forEach { destination ->

            NavigationBarItem(
                // Highlight selected tab
                selected = currentRoute == destination.route,

                // Navigate when clicked
                onClick = {
                    navController.navigate(destination.route) {

                        // Prevent many copies of same screen
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }

                        // Avoid reloading same screen
                        launchSingleTop = true

                        // Restore previous state
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.contentDescription
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
