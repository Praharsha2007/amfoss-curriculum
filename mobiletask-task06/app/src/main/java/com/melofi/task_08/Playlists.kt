package com.melofi.task_08

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavHostController



data class Song(
    val title: String,
    val artist: String,
    val image: Int
)

data class Playlist(
    val name: String,
    val image: Int,
    val songs: List<Song>
)

@Composable
fun Playlists(navController: NavHostController) {

    val playlists = listOf(
        Playlist(
            name = "Blinding Lights",
            image = R.drawable.album,
            songs = listOf(
                Song("Blinding Lights", "The Weeknd", R.drawable.album),
                Song("Save Your Tears", "The Weeknd", R.drawable.album),
                Song("Starboy", "The Weeknd", R.drawable.album)
            )
        )
    )

    var selectedPlaylist by remember { mutableStateOf<Playlist?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        if (selectedPlaylist == null) {
            Playlist_Cards(playlists) { clickedPlaylist ->
                selectedPlaylist = clickedPlaylist
            }
        } else {
            PlaylistSongsScreen(
                playlist = selectedPlaylist!!,
                onBack = { selectedPlaylist = null },
                navController = navController       
            )
        }
    }
}


@Composable
fun Playlist_Cards(
    playlists: List<Playlist>,
    onPlaylistClick: (Playlist) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 20.dp)
    ) {

        Text(
            text = "Your Playlists",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(start = 4.dp)
        ) {
            items(playlists.size) { index ->
                val playlist = playlists[index]

                PlaylistCard(
                    songTitle = playlist.name,
                    albumArt = playlist.image,
                    onPlayClick = {
                        onPlaylistClick(playlist)
                    }
                )
            }
        }
    }
}
@Composable
fun PlaylistSongsScreen(
    playlist: Playlist,
    onBack: () -> Unit,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = "← Back",
                color = Color.White,
                modifier = Modifier.clickable { onBack() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = playlist.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            items(playlist.songs.size) { index ->
                val song = playlist.songs[index]

                Playlist_SongCard(
                    songTitle = song.title,
                    artist = song.artist,
                    albumArt = song.image,
                    onPlayClick = {
                        navController.navigate("player")
                    }
                )
            }
        }
    }
}

