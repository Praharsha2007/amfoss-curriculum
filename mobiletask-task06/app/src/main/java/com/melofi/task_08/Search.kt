package com.melofi.task_08

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.melofi.task_08.Song

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Search(navController: NavHostController) {

    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        SearchBar(
            input = input,
            onInputChange = { input = it },
            onBackClick = { navController.popBackStack() }
        )

        SongList()
    }
}

@Composable
fun SearchBar(
    input: String,
    onInputChange: (String) -> Unit,
    onBackClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = onBackClick) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
        }

        OutlinedTextField(
            value = input,
            onValueChange = onInputChange,
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
fun SongList() {

    val songs = emptyList<Song>()

    LazyColumn(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        items(songs) { song ->
            SongCard(song = song)
        }
    }
}

@Composable
fun SongCard(song: Song) {

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
                painter = painterResource(id = R.drawable.album),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified
            )


            Column(modifier = Modifier.padding(start = 10.dp)) {

                Text(
                    text = song.trackName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = song.artistName,
                    fontSize = 11.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}

