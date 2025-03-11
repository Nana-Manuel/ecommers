package screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commers.R
import com.example.e_commers.ui.theme.EcommersTheme

@Composable
fun ForgetPasswordScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back Button
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.Start)
                .size(50.dp)
                .padding(top = 20.dp)
                .clickable {

                }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = "Forgot Password",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Please enter your email address. You will receive a link to create a new password via email",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.align(Alignment.Start)
        )


        Spacer(modifier = Modifier.height(30.dp))

        // Input Fields
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    "Email",
                    fontWeight = FontWeight.Light
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))



        Button(
            onClick = { /* Handle sign-up */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Send", color = Color.White, fontSize = 16.sp)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ForgetPasswordScreenPreview() {
    EcommersTheme {
        ForgetPasswordScreen()
    }
}


