package com.example.e_commers.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun LoginScreen() {
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
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Input Fields
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text("Email",
                    fontWeight = FontWeight.Light) },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent),
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text("Password",
                    fontWeight = FontWeight.Light) },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent),
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Already have an account
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.End)
                .clickable {

                }
        ){
            Text(text = "Forgot your password",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
                )
            Image(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sign Up Button
        Button(
            onClick = { /* Handle sign-up */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Login", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.padding(vertical = 100.dp))


        // Social Login
        Column (modifier = Modifier
            .fillMaxHeight(0.4f)
        ) {

            Text("Or login with social account")

            Row(
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {

                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Google",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {

                        }
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    EcommersTheme {
        LoginScreen()
    }
}


