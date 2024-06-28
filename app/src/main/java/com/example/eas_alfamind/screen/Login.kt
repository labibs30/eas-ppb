package com.example.eas_alfamind.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eas_alfamind.R

@Composable
fun Login(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember{
        mutableStateOf("")
    }
    var showError by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((LocalConfiguration.current.screenHeightDp.dp) * 0.5f)
                .background(Color.Red),
            contentAlignment = Alignment.Center // Tengahkan isi dari Box
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "First Store Owner in Indonesia",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Tengahkan teks secara horizontal
                )
                Image(
                    painter = painterResource(id = R.drawable.unnamed),
                    contentDescription = "App Logo",
                    modifier = Modifier,
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Column {
                Text(
                    text = "No Hp Kamu",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp) // Padding bawah agar tidak rapat dengan input
                )

                BasicTextField(
                    value = TextFieldValue(text = phoneNumber),
                    onValueChange = { phoneNumber = it.text
                        showError = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White), // Ganti dengan warna latar belakang yang diinginkan
                    textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                    cursorBrush = SolidColor(Color.Black),
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .border(3.dp, Color.Red, RoundedCornerShape(8.dp))
                            , // Tambahkan border dengan warna merah
                        ) {
                            innerTextField()
                        }
                    }
                )
            }

            Column {
                Text(
                    text = "Password",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp) // Padding bawah agar tidak rapat dengan input
                )

                BasicTextField(
                    value = TextFieldValue(text = password),
                    onValueChange = { password = it.text
                        showError = false},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White), // Ganti dengan warna latar belakang yang diinginkan
                    textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                    cursorBrush = SolidColor(Color.Black),
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .border(3.dp, Color.Red, RoundedCornerShape(8.dp))
                            , // Tambahkan border dengan warna merah
                        ) {
                            innerTextField()
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            // Login button
            Button(
                onClick = { if (phoneNumber.isNotBlank() && password.isNotBlank()) {
                    navController.navigate("dashboard/$phoneNumber")
                } else {
                    showError = true
                }},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if (showError) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "handphone and Password cannot be empty",
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Belum punya akun? ",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 4.dp) // Padding di sebelah kanan agar tidak rapat dengan "Klik disini"
                )

                Text(
                    text = "Klik disini",
                    color = Color.Red, // Warna teks merah
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable(onClick = { navController.navigate("register") })
                )
            }
        }

    }
}
