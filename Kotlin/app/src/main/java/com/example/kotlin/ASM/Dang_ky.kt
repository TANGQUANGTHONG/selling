package com.example.kotlin.ASM

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import coil.network.HttpException
import kotlinx.coroutines.launch
import java.io.IOException


@Composable
fun dang_ky(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    // Sử dụng CoroutineScope để gọi hàm suspend
    val coroutineScope = rememberCoroutineScope()

    // Hàm gọi API đăng ký
    fun register() {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()) {
            message = "Vui lòng điền tất cả các trường."
            return
        }

        if (password != confirmpassword) {
            message = "Password không khớp"
            return
        }

        // Khởi chạy coroutine
        coroutineScope.launch {
            try {
                val request = RegisterRequest(Email = email, Password = password, Username = username)
                println("Register Request: Email=$email, Username=$username, Password=$password") // Ghi log
                val response = ApiClient.apiService.registerUser(request)
                navController.navigate("dang_nhap")
            } catch (e: IOException) {
                message = "Lỗi mạng, vui lòng kiểm tra kết nối."
            }
        }
    }


        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "WELCOME",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                // Box chứa các TextField
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(8.dp, shape = RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Column {
                        Text(text = "Name")
                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
                        )

                        Text(text = "Email")
                        TextField(
                            value = email,
                            onValueChange = { email = it },
                            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
                        )

                        Text(text = "Password")
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
                        )

                        Text(text = "Confirm Password")
                        TextField(
                            value = confirmpassword,
                            onValueChange = { confirmpassword = it },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Button(
                            onClick = { register() },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFA000000),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "SIGN UP")
                        }

                        if (message.isNotEmpty()) {
                            Text(
                                text = message,
                                color = Color.Red,
                                modifier = Modifier.padding(top = 20.dp)
                            )
                        }

                        Row(
                            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 20.dp)
                        ) {
                            Text(text = "Already have an account? ", color = Color.Gray)
                            Text(
                                text = "SIGN IN",
                                fontSize = 18.sp,
                                color = Color.Black,
                                modifier = Modifier.clickable { navController.navigate("dang_nhap") }
                            )
                        }
                    }
                }
            }
        }
    }
