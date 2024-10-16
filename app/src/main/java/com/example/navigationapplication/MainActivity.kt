package com.example.navigationapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationapplication.ui.theme.NavigationApplicationTheme
import com.example.navigationapplication.ui.theme.forgotScreen
import com.example.navigationapplication.ui.theme.signinScreen
import com.example.navigationapplication.ui.theme.sugnUpScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use setContent to define the composable scope
        setContent {
            NavigationApplicationTheme {
                // Call the SetupNavGraph() inside the composable scope
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    // Define the navigation graph here
    NavHost(navController = navController, startDestination = "screen1") {
        composable(route = "screen1") {
            Screen1(navController)
        }
        composable(route = "screen2") {
            Screen2(navController)
        }
        composable(route = "screen3") {
            Screen3(navController)
        }
        composable(route = "screen4") {
            Screen4(navController)
        }
    }
}

@Composable
fun Screen1(navController: NavHostController) {
signinScreen(navController = navController)

}

@Composable
fun Screen2(navController: NavHostController) {


    sugnUpScreen(navController = navController)
}

@Composable
fun Screen3(navController: NavHostController) {
    forgotScreen(navController = navController)
}

@Composable
fun Screen4(navController: NavHostController) {
    forgotScreen(navController = navController)
}
