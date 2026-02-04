package com.melofi.task_08

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavHostController


//navhost stores all the screens and is liek a tv while navcontroller si the remote and is used to switch screens. navcontroller keeps a back stack.
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
                        composable(route = "player"){
                            PlayerScreen(navController)
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

@Composable //Enables function to call other composable functions within it.
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
            fontFamily = FontFamily.SansSerif,
        )
    }
}
@Composable
fun RecentlyPlayed(navController: NavHostController) { //A functions is created and it needs a navigation controller object. NavHostController is the type of navigation controller.

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
                    albumArt = R.drawable.album //R is for reesources. It is a class automatically generated by Android. Drawable is inside res folder and inside that album is a png file stored.
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

