package com.example.e_commers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import screens.BottomNavItem

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, "home"),
        BottomNavItem("Shop", Icons.Default.ShoppingCart, "shop"),
        BottomNavItem("Bag", Icons.Default.ShoppingCart, "bag"),
        BottomNavItem("Favorites", Icons.Default.FavoriteBorder, "favorites"),
        BottomNavItem("Profile", Icons.Default.Person, "profile")
    )

    var selectedItem by remember { mutableIntStateOf(0) }


    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selectedItem == index) Color.Red else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (selectedItem == index) Color.Red else Color.Gray,
                        fontSize = 12.sp
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        popUpTo("home") { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}