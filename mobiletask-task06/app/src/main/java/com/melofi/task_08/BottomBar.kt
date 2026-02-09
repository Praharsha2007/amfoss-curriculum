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
        navController.currentBackStackEntryAsState().value //It updates the value whenever the screen changes. .value gets the current back stack entry.
            ?.destination?.route //safely extracts destination and route. Due to ? wont crash even if null.

    val destinations = listOf(
        Destination.Home,
        Destination.Search,
        Destination.Playlists
    ) //Shows a list of the screens which the bottom bar will be able to navigate between.

    NavigationBar(
        containerColor = Color(0xFF9B7A5B),
    ) {

        destinations.forEach { destination -> //Looping through each screen

            NavigationBarItem(

                selected = currentRoute == destination.route, //When looped, it checks if the screen is the one which is active.

                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.startDestinationId) { //Pops back to the start destination before navigation.
                            saveState = true
                        }
                        launchSingleTop = true //Prevents creating multiple instances of the same screen.
                        restoreState = true //It restores the previously stored data.
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
