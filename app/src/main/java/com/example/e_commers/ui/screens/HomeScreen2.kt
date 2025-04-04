package com.example.e_commers.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commers.R


@Composable
fun HomeScreen2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NewCollection()
        CategoryGrid()
    }
}


@Composable
fun NewCollection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        Image(
            painter = painterResource(R.drawable.new_collection),
            contentDescription = "New Collection",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "New collection",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}

// CATEGORY GRID
@Composable
fun CategoryGrid() {
    Row (modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.5f)
        ){
            SummerSale()
            BlackCollection()
        }
        MensHoodies()
    }
}

@Composable
fun SummerSale() {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .background(Color.White)
            .padding(25.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Summer Sale",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
    }
}


@Composable
fun BlackCollection() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.black_collection),
            contentDescription = "Black Collection",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "Black",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(16.dp)
        )
    }
}

@Composable
fun MensHoodies() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.mens_hoodies), // Replace with actual image
            contentDescription = "Men’s Hoodies",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "Men’s hoodies",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 35.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHome2() {
//    HomeScreen2()
}

