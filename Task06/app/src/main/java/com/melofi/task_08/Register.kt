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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import org.w3c.dom.Text
import java.time.format.TextStyle

class Register : ComponentActivity() {
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
                        Melofi(name = "Melofi")
                        Email(name = "Email")
                        Username(name = "Username")
                        Password(name = "Password")
                        Register_Button(name = "Register")
                        Login_Button(name = "Login")
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
fun Email(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxWidth().padding(top = 100.dp)
    ){
        Text(
            text = "Enter Email...."
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your email...")},
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}}
@Composable
fun Username(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
    ){
        Text(
            text = "Enter Username...."
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your username...")},
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}
@Composable
fun Password(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
    ){
        Text(
            text = "Enter Password...."
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your password...")},
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}
@Composable
fun Melofi(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 50.dp),
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
fun Register_Button(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(top = 20.dp),

        ) {
        Button(
            onClick = {
                print("h")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),

            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            )

        ) {
            Text(text = "Register",
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Login_Button(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(top = 10.dp),

        ) {
        Button(
            onClick = {
                print("h")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),

            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            )

        ) {
            Text(text = "Login",
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}
