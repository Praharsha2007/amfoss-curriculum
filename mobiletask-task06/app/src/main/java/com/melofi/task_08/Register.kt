package com.melofi.task_08

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
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

/* ---------------- REGISTER SCREEN ---------------- */

@Composable
fun Register(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {
        T()
        Register_Title()
        Email()
        Username()
        Password()
        Registering(navController)
        Log(navController)
    }
}

/* ---------------- UI PARTS ---------------- */

@Composable
fun Register_Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "REGISTER",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun Email() {
    var email by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ){
        Text(text = "Enter Email", color = Color.White)

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter your email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "EmailIcon")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Composable
fun Username() {
    var username by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ){
        Text(text = "Enter Username", color = Color.White)

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter your username") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(Icons.Default.AccountCircle, contentDescription = "UsernameIcon")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Composable
fun Password() {
    var password by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ){
        Text(text = "Enter Password", color = Color.White)

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Enter your password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "PasswordIcon")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Composable
fun T() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "MeLofi",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Text(
            text = "Where music feels like home",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.LightGray
        )
    }
}

/* ---------------- BUTTONS WITH NAVIGATION ---------------- */

@Composable
fun Registering(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Button(
            onClick = {
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
            Text(
                text = "Register",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Log(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "If you already have an account, then Login",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF9B7A5B)
            )
        ) {
            Text(
                text = "Login",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}
