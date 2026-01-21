package com.melofi.task_08
import android.os.Bundle
import android.widget.Button
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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task08Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Greeting(name = "Android")

                        Next_Button(name = "NextButton")
                    }
                }

            }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 200.dp),
            verticalArrangement = Arrangement.Center
        ){
        Text(
            text = "MeLofi",
            modifier = modifier.fillMaxWidth(),
            fontSize = 45.sp,
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
fun Next_Button(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,

    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Moving to the next screen...", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.padding(bottom = 100.dp, start = 130.dp).size(height = 50.dp, width = 100.dp),
            shape = RoundedCornerShape(15.dp),

            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            )

        ) {
            Text(text = "Next",
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
                )
        }
    }
}
