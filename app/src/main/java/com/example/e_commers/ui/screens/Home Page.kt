package com.example.e_commers.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commers.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HeroSection()
        NewArrivalsSection()
        SaleSection()
    }

}


@Composable
fun HeroSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.hero_image),
            contentDescription = "Fashion Sale",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(16.dp)
        ) {
            Text(
                text = "Fashion",
                fontSize = 35.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "Sale",
                fontSize = 35.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Check", color = Color.White)
            }
        }
    }
}

@Composable
fun NewArrivalsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "New", fontSize = 24.sp)
        Text(text = "You’ve never seen it before!", fontSize = 14.sp, color = Color.Gray)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            items(listOf(R.drawable.image1,
                        R.drawable.image2,
                        R.drawable.image3,
                        R.drawable.image4)
            )
            { imageRes ->
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(imageRes),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .padding(8.dp) // Ensures some spacing from edges
                            .background(Color.Black, shape = RoundedCornerShape(6.dp))
                            .padding(
                                horizontal = 8.dp, vertical = 4.dp
                            ) // Padding inside the "NEW" box
                            .align(Alignment.TopStart) // Positions it at the top-left corner
                    ) {
                        Text(
                            text = "NEW",
                            fontSize = 10.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun SaleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "On Sale",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val saleItems = listOf(
                SaleItem(R.drawable.sale1, "Striped Wrap Blouse", 39.99, 4.5, 20),
                SaleItem(R.drawable.sale2, "Casual Denim Jacket", 49.99, 4.8, 15),
                SaleItem(R.drawable.image4, "Summer Floral Dress", 29.99, 4.3, 10)
            )

            saleItems.forEach { item ->
                Column(
                    modifier = Modifier
                        .width(140.dp) // Ensures text fits below image
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(140.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(item.imageRes),
                            contentDescription = item.name,
                            contentScale = ContentScale.Crop
                        )

                        // Discount Badge
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .background(Color.Red, shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                .align(Alignment.TopStart)
                        ) {
                            Text(
                                text = "-${item.discount}%",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Item Name
                    Text(
                        text = item.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    // Star Rating
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(item.rating.toInt()) {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Star",
                                tint = Color(0xFFFFD700), // Gold color
                                modifier = Modifier.size(14.dp)
                            )
                        }
                        if (item.rating % 1 != 0.0) {
                            Icon(
                                imageVector = Icons.Filled.StarHalf,
                                contentDescription = "Half Star",
                                tint = Color(0xFFFFD700),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }

                    // Price
                    Text(
                        text = "$${item.price}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

// Data class for sale items
data class SaleItem(
    val imageRes: Int,
    val name: String,
    val price: Double,
    val rating: Double,
    val discount: Int // Discount percentage
)




@Preview(showBackground = true)
@Composable
fun PreviewFashionSaleScreen() {
    HomeScreen()
}
