package com.melofi.task_08

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Search(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Searchbar(navController)
        Songs()
    }
}

@Composable
fun Searchbar(navController: NavHostController) {

    var input by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
        }

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Search..", fontSize = 12.sp) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "SearchIcon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        )
    }
}


@Composable
fun Songs() {

    LazyColumn(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        items(8) {
            SearchCard(
                songTitle = "Blinding Lights",
                artist = "The Weeknd",
                albumArt = R.drawable.album
            )
        }
    }
}


@Composable
fun SearchCard(
    songTitle: String,
    artist: String,
    albumArt: Int
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF9B7A5B)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = albumArt),
                contentDescription = "Album Art",
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified
            )

            Column(modifier = Modifier.padding(start = 10.dp)) {

                Text(
                    text = songTitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = artist,
                    fontSize = 11.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}
