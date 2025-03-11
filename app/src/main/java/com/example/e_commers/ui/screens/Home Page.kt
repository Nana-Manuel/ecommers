package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commers.R

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column() {
            HeroSection()
            NewArrivalsSection()
        }
    }

}



@Composable
fun HeroSection() {
    Box(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(0.7f)) {
        Image(
            painter = painterResource(id = R.drawable.hero_image),
            contentDescription = "Fashion Sale",
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.align(Alignment.CenterStart).padding(16.dp)) {
            Text(text = "Fashion Sale", fontSize = 32.sp, color = Color.White)
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
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewFashionSaleScreen() {
    HomeScreen()
}
