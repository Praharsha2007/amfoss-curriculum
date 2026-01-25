package com.melofi.task_08

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import com.melofi.task_08.ui.theme.Task08Theme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        

        setContent {
            Task08Theme {

                val navController = rememberNavController()

                val currentRoute =
                    navController.currentBackStackEntryAsState().value
                        ?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    bottomBar = {
                        if (currentRoute != "login" && currentRoute != "register") {
                            BottomBar(navController)
                        }
                    }

                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {


                        composable("login") {
                            Login(navController)
                        }

                        composable("register") {
                            Register(navController)
                        }

                        composable(Destination.HOME.route) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black)
                            ) {
                                Melofi(name = "Melofi")
                                RecentlyPlayed(navController)
                                Trending(navController)
                            }
                        }
                        composable(route = "player"){
                            PlayerScreen(navController)
                        }

                        // SEARCH SCREEN
                        composable(Destination.SEARCH.route) {
                            Search(navController)
                        }

                        // PLAYLISTS SCREEN
                        composable(Destination.PLAYLISTS.route) {
                            Playlists(navController)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Melofi(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "MeLofi",
            modifier = modifier.fillMaxWidth(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Where music feels like home",
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
        )
    }
}
@Composable
fun RecentlyPlayed(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {

        Text(
            text = "Recently Played",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(start = 12.dp)
        ) {

            item {
                SongCard(
                    songTitle = "Blinding Lights",
                    artist = "The Weeknd",
                    albumArt = R.drawable.album
                ) { navController.navigate("player")}
            }
            item {
                SongCard(
                    songTitle = "Perfect",
                    artist = "Ed Sheeran",
                    albumArt = R.drawable.album
                ) {navController.navigate("player") }
            }

            item {
                SongCard(
                    songTitle = "Believer",
                    artist = "Imagine Dragons",
                    albumArt = R.drawable.album
                ) { navController.navigate("player")}
            }
        }
    }
}
@Composable
fun Trending(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Text(
            text = "Trending Songs",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(start = 12.dp)
        ) {

            item {
                SongCard(
                    songTitle = "Blinding Lights",
                    artist = "The Weeknd",
                    albumArt = R.drawable.album
                ) { navController.navigate("player")}
            }
            item {
                SongCard(
                    songTitle = "Perfect",
                    artist = "Ed Sheeran",
                    albumArt = R.drawable.album
                ) {navController.navigate("player") }
            }

            item {
                SongCard(
                    songTitle = "Believer",
                    artist = "Imagine Dragons",
                    albumArt = R.drawable.album
                ) {navController.navigate("player") }
            }
        }
    }
}

