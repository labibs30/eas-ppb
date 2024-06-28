package com.example.eas_alfamind.components.bottom_navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eas_alfamind.Dashboard
import com.example.eas_alfamind.data.Screen
import com.example.eas_alfamind.Profile
import com.example.eas_alfamind.Transaction
import com.example.eas_alfamind.Profile

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Dashboard.route) { Dashboard("user@example.com", navController) }
            composable(Screen.Transaction.route) { Transaction() }
            composable(Screen.Profile.route) { Profile(navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(Screen.Dashboard, Screen.Transaction, Screen.Profile)
    NavigationBar(
        containerColor = Color.Red,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            val isSelected = currentRoute == screen.route
            val color = if (isSelected) Color.LightGray else MaterialTheme.colorScheme.onPrimary
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title, tint = color) },
                label = { Text(screen.title, color = color) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.primary)
            )
        }
    }
}
