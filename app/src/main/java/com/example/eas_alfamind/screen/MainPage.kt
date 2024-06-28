package com.example.eas_alfamind.screen


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eas_alfamind.Dashboard
import com.example.eas_alfamind.Profile
import com.example.eas_alfamind.Transaction
import com.example.eas_alfamind.components.bottom_navigation.BottomNavigationBar
import com.example.eas_alfamind.data.Screen

@Composable
fun MainPage(handphone: String, navController: NavHostController) {
    val nestedNavController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(nestedNavController) }
    ) { innerPadding ->
        NavHost(
            navController = nestedNavController,
            startDestination = Screen.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Dashboard.route) { Dashboard(handphone, navController) }
            composable(Screen.Transaction.route) { Transaction() }
            composable(Screen.Profile.route) { Profile(navController) }
        }
    }
}