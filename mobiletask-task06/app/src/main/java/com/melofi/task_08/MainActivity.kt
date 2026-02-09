package com.melofi.task_08
import com.melofi.task_08.RetrofitInstance
import com.melofi.task_08.Song
import androidx.compose.runtime.*

import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import retrofit2.Response
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


//navhost stores all the screens and is like a tv while navcontroller si the remote and is used to switch screens. navcontroller keeps a back stack.
class MainActivity : ComponentActivity() { // A class is a blueprint for creating objects. A class is a design and an object is the real thing created from that design.
    // : means inheritance. MainActivity inherits from Component Activity, Takes all properties and functions from another class.
    //Override means replacing a function from the parent class with my own version.
    // ComponentActivity already has onCreate(). So we are customising what happens when activity starts.
    override fun onCreate(savedInstanceState: Bundle?) { //Bundle is used to save UI state and restore app after crash. ? means it can be null.
        super.onCreate(savedInstanceState)

        setContent { //Inside setContent we write composable functions.
            Task08Theme { //This is a composable function that applies colors, typography, shapes and material theme.


                //navcontroller is basically a central api used to allow navigation in jetpack compose. It tracks the user's navigation history, it basically keeps score of all the screens visited.
                val navController = rememberNavController()

                val currentRoute =
                    navController.currentBackStackEntryAsState().value
                        ?.destination?.route
                //currentBackStackEntryAsState It returns the top entry on the back stack.
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //scaffold provides a structural layout for the app. It offers predefined slots like topappbar bottomapp bar, floatingactionbutton.
                    //TopAppBar displays the app title, navigation icons and action buttons on top of the screen while the BottomAppBar hosts primary navigation actions or controls at the bottom.
                    //bottomBar is predefined under Scaffold.
                    bottomBar = {
                        if (currentRoute != "login" && currentRoute != "register") {
                            BottomBar(navController)
                        }
                    }

                ) { innerPadding ->
                    //innerPadding is automatically calculated

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

                        composable("home") {
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
                        composable(
                            route = "player/{title}/{artist}/{cover}",
                            arguments = listOf(
                                navArgument("title") { defaultValue = "" }, //It declares the expected argument.
                                navArgument("artist") { defaultValue = "" },
                                navArgument("cover") { defaultValue = "" }
                            )
                        ) { backStackEntry ->

                            val title = backStackEntry.arguments?.getString("title") ?: "" //It reads the "title" from the navigation.
                            val artist = backStackEntry.arguments?.getString("artist") ?: ""
                            val cover = backStackEntry.arguments?.getString("cover") ?: ""

                            PlayerScreen(
                                navController = navController,
                                title = title,
                                artist = artist,
                                cover = cover
                            )
                        }

                        composable("search") {
                            Search(navController)
                        }

                        composable("playlists") {
                            Playlists(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Melofi(name: String, modifier: Modifier = Modifier) { //Whenever we call this particular function we need to call it with a string parameter passed into it.
    Column( //Modifier tells UI elements how to lay out, display. In this function the line makes the modifier thing optional because it has a default value called Modifier. Without the default value, would be forced to pass a modifier every time.
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        verticalArrangement = Arrangement.Center //Arranges the children element or items in the vertical direction.
        //horizontalAlignment positions the children horizontally
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
            fontFamily = FontFamily.SansSerif
        )
    }
}

@Composable
fun RecentlyPlayed(navController: NavHostController) {

    fun navigate(title: String, artist: String) {
        val encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8.toString()) //Because navigation routes cannot include spaces.
        val encodedArtist = URLEncoder.encode(artist, StandardCharsets.UTF_8.toString())

        navController.navigate("player/$encodedTitle/$encodedArtist/empty")
    }

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
                    albumArtUrl = null
                ) {
                    navigate("Blinding Lights", "The Weeknd") //Needs to pass two parameters for the function to work.
                }
            }

            item {
                SongCard(
                    songTitle = "Perfect",
                    artist = "Ed Sheeran",
                    albumArtUrl = null
                ) {
                    navigate("Perfect", "Ed Sheeran")
                }
            }

            item {
                SongCard(
                    songTitle = "Believer",
                    artist = "Imagine Dragons",
                    albumArtUrl = null
                ) {
                    navigate("Believer", "Imagine Dragons")
                }
            }
        }
    }
}


@Composable
fun Trending(navController: NavHostController) {

    var songs by remember { mutableStateOf<List<Song>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getTrending()
            if (response.isSuccessful) {
                songs = response.body() ?: emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

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

            items(songs) { song ->

                SongCard(
                    songTitle = song.trackName,
                    artist = song.artistName,
                    albumArtUrl = song.cover
                ) {

                    val encodedTitle = URLEncoder.encode(song.trackName, StandardCharsets.UTF_8.toString())
                    val encodedArtist = URLEncoder.encode(song.artistName, StandardCharsets.UTF_8.toString())
                    val encodedCover = URLEncoder.encode(song.cover ?: "empty", StandardCharsets.UTF_8.toString())

                    navController.navigate("player/$encodedTitle/$encodedArtist/$encodedCover")
                }
            }
        }
    }
}
