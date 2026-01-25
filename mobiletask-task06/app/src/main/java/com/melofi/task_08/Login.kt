package com.melofi.task_08

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.input.PasswordVisualTransformation

/* ---------------- LOGIN SCREEN ---------------- */

@Composable
fun Login(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {
        Title()
        Login_Title()
        Username_Field()
        Password_Field()
        Login_Button(navController)
        Register_Button(navController)
    }
}

/* ---------------- UI PARTS ---------------- */

@Composable
fun Title() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Text(
            text = "MeLofi",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Where music feels like home",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
        )
    }
}

@Composable
fun Login_Title(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "LOGIN",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Username_Field(){
    var username by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Text(text = "Enter username")

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "UsernameIcon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Composable
fun Password_Field(){
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    ) {
        Text(text = "Enter Password")

        OutlinedTextField(
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { password = it },
            label = { Text("Enter password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "PasswordIcon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

/* ---------------- BUTTONS WITH NAVIGATION ---------------- */

@Composable
fun Login_Button(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                // 🔥 After login → go to HOME
                navController.navigate(Destination.HOME.route) {
                    popUpTo("login") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF9B7A5B)
            )
        ) {
            Text("LOGIN", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun Register_Button(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
    ) {
        Text(
            text = "If you do not have an account, then Register",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Button(
            onClick = {
                // 🔥 Go to Register screen
                navController.navigate("register")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF9B7A5B)
            )
        ) {
            Text("REGISTER", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}
