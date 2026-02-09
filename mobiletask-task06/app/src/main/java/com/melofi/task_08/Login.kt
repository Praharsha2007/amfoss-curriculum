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
import kotlinx.coroutines.launch


@Composable
fun Login(navController: NavHostController) {

    var username by remember { mutableStateOf("") } //Creates a state object. When the data in it changes the UI updates accordingly. Mutable means that the value can be changed after its creation.
    var password by remember { mutableStateOf("") } //without remember it resets to null each time.
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
        ) {
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
                color = Color.LightGray
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "LOGIN",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text("Enter Username", color = Color.White)
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter username") },
            leadingIcon = { Icon(Icons.Default.AccountCircle, null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text("Enter Password", color = Color.White)
        OutlinedTextField(
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { password = it },
            label = { Text("Enter password") },
            leadingIcon = { Icon(Icons.Default.Lock, null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                scope.launch {
                    errorMessage = null

                    try {
                        val response = RetrofitInstance.api.login(
                            LoginRequest(username, password)
                        )

                        if (response.isSuccessful) {
                            navController.navigate("home") {
                                popUpTo("login") { inclusive = true }
                            }
                        } else {
                            errorMessage = "Invalid username or password"
                        }

                    } catch (e: Exception) {
                        errorMessage = "Network error"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9B7A5B)
            )
        ) {
            Text(
                "LOGIN",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        errorMessage?.let {
            Text(
                text = it,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "If you do not have an account, then Register",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Button(
            onClick = {
                navController.navigate("register")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9B7A5B)
            )
        ) {
            Text(
                "REGISTER",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
