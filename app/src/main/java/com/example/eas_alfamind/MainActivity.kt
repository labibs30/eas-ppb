package com.example.eas_alfamind

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.eas_alfamind.screen.Login
import com.example.eas_alfamind.screen.MainPage
import com.example.eas_alfamind.screen.Product
import com.example.eas_alfamind.screen.ProductDetail
import com.example.eas_alfamind.screen.Register
import com.example.eas_alfamind.ui.theme.Eas_alfamindTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Eas_alfamindTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login"){
                        composable("login"){ Login(navController)}
                        composable("register"){ Register(navController) }
                        composable("dashboard/{handphone}", arguments = listOf(navArgument("handphone"){
                            type = NavType.StringType
                        })){ backStackEntry ->
                            val handphone = backStackEntry.arguments?.getString("handphone") ?: ""
                            MainPage(handphone = handphone, navController = navController)
                        }
                        composable(
                            route = "product_category/{category_id}",
                            arguments = listOf(navArgument("category_id") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val category_id = backStackEntry.arguments?.getInt("category_id") ?: 0
                            Product(category_id = category_id, navController)
                        }
                        composable(
                            route = "product_detail/{product_id}",
                            arguments = listOf(navArgument("product_id") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val product_id = backStackEntry.arguments?.getInt("product_id") ?: 0
                            ProductDetail(product_id = product_id, navController = navController)
                        }
                    }
                }
            }
        }
    }
}
