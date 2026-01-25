package com.melofi.task_08

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("home", "Home", Icons.Filled.Home, "Home Screen"),
    SEARCH("search", "Search", Icons.Filled.Search, "Search Screen"),
    PLAYLISTS("playlists", "Playlists", Icons.AutoMirrored.Filled.List, "Playlists Screen")
}
