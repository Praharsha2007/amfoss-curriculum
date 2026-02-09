package com.melofi.task_08

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


//Sealed class is a restricted class hierarchy. So everything related to it must be defined in its own file only. Cannot randomly extend it from somewhere else. Sealed class can handle dynamic routing but enum cannot Enum is for fixed constants.                        
sealed class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector
)  {

    object Home : Destination(
        route = "home",
        label = "Home",
        icon = Icons.Filled.Home
    )

    object Search : Destination(
        route = "search",
        label = "Search",
        icon = Icons.Filled.Search
    )

    object Playlists : Destination(
        route = "playlists",
        label = "Playlists",
        icon = Icons.AutoMirrored.Filled.List
    )
}
