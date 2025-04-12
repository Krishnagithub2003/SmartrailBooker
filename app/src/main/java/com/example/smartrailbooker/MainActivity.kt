package com.example.smartrailbooker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.smartrailbooker.ui.theme.SmartrailBookerTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartrailBookerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun <NavController> SplashScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00AA4F))
    ) {
        Text(
            text = "Smartrail Booker",
            style = MaterialTheme.typography.displaySmall,
            color = Color.White
        )
    }
    // Navigate to home after a delay
    LaunchedEffect(Unit) {
        delay(1000) // 1-second splash
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }  // Clears backstack
        }
    }
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartrailbookerTheme {
                // Display Login Screen
                LoginScreen(onSendOTP = { phoneNumber ->
                    // Handle OTP logic here
                    println("OTP Sent to $phoneNumber")
                    // Navigate to next screen or show Toast etc.
                })
            }
        }
    }
}