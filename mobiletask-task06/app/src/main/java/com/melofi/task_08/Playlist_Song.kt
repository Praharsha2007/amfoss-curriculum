package com.melofi.task_08
import android.R
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.melofi.task_08.ui.theme.Task08Theme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import java.time.format.TextStyle


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

