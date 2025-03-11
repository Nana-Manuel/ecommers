package com.example.e_commers

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    val bottomBarPadding = getNavigationBarHeight()

    Column (modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))){
        Divider(color = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray, thickness = 0.3.dp, startIndent = 0.dp,)

        BottomNavigation(
            backgroundColor = MaterialTheme.colorScheme.surface,
            elevation = 35.dp,
            modifier = Modifier.padding(bottom = bottomBarPadding-7.dp)
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


}

// Function to get system navigation bar height
@Composable
fun getNavigationBarHeight(): Dp {
    val view = LocalView.current
    val density = LocalDensity.current
    val insets = ViewCompat.getRootWindowInsets(view)

    val bottomInset = insets?.systemGestureInsets?.bottom ?: 0 // Safe check for null

    return with(density) { bottomInset.toDp() }
}
