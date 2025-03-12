package com.example.e_commers

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.BagScreen
import screens.FavoritesScreen
import com.example.e_commers.ui.screens.HomeScreen
import screens.ProfileScreen
import screens.Shop_Screen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomNavBar(navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") { HomeScreen() }
                composable("shop") { Shop_Screen() }
                composable("bag") { BagScreen() }
                composable("favorites") { FavoritesScreen() }
                composable("profile") { ProfileScreen() }
            }
        }

}

