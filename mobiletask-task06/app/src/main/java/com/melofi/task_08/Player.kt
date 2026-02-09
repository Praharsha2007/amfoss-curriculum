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
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.SkipNext

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
@Composable
fun PlayerScreen(
    navController: NavHostController,
    title: String,
    artist: String,
    cover: String
) {

    val decodedTitle = URLDecoder.decode(title, StandardCharsets.UTF_8.toString())
    val decodedArtist = URLDecoder.decode(artist, StandardCharsets.UTF_8.toString())
    val decodedCover = URLDecoder.decode(cover, StandardCharsets.UTF_8.toString())

    val imageUrl = if (decodedCover == "empty") null else decodedCover

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "←",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(30.dp))

        AsyncImage(
            model = imageUrl,
            contentDescription = "Album Art",
            placeholder = painterResource(R.drawable.album),
            error = painterResource(R.drawable.album),
            modifier = Modifier
                .size(220.dp)
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = decodedTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = decodedArtist,
            fontSize = 18.sp,
            color = Color.Gray
        )
    }
}
