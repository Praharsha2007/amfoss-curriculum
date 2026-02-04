package com.melofi.task_08

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun Playlist_SongCard(
    songTitle: String,
    artist: String,
    albumArt: Int,
    onPlayClick: () -> Unit
){
    Card(
        modifier = Modifier.fillMaxWidth().height(70.dp).clickable {onPlayClick()},
        shape = RoundedCornerShape(  15.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3A3429)
        )
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
        ) {
            Image(
                painter = painterResource(id = albumArt),
                contentDescription = "Album Art",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = songTitle,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " --" + artist,
                fontSize = 10.sp,

                )
        }
    }
}

