package com.example.kotlin.ASM

import android.net.http.HttpException
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin.R
import kotlinx.coroutines.launch
import java.io.IOException

@Composable
fun dang_nhap(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    // Nhận CoroutineScope
    val coroutineScope = rememberCoroutineScope()

    // Hàm gọi API đăng nhập
    fun login() {
        if (username.isEmpty() || password.isEmpty()) {
            message = "Vui lòng điền đầy đủ thông tin!."
            return
        }

        isLoading = true

        // Khởi chạy coroutine để gọi API
        coroutineScope.launch {
            try {
                val request = LoginRequest(Username = username, Password = password)
                val response = ApiClient.apiService.loginUser(request)

                if (response.isSuccessful) {
                    navController.navigate("Homene")
                } else {
                    message = "Thông tin đăng nhập không đúng, vui lòng thử lại."
                }
            } catch (e: IOException) {
                message = "Lỗi mạng, vui lòng kiểm tra kết nối."

            } finally {
                isLoading = false // Kết thúc trạng thái loading
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header với hình ảnh và khoảng cách
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = null,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(30.dp)
                )
            }

            Text(
                text = "Hello !",
                color = Color(0xFFC0C0C0),
                fontSize = 30.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .padding(start = 20.dp)
                    .align(Alignment.Start)
            )
            Text(
                text = "WELCOME BACK",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .padding(start = 20.dp)
                    .align(Alignment.Start)
            )

            Box(
                modifier = Modifier
                    .height(400.dp)
                    .width(700.dp)
                    .padding(start = 0.dp)
                    .shadow(8.dp, shape = RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .align(Alignment.Start)
                    .padding(16.dp)
            ) {
                Column {
                    Text(text = "Name")
                    TextField(
                        value = username, onValueChange = { username = it },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    Text(text = "Password")
                    TextField(
                        value = password, onValueChange = { password = it },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Nút SIGN IN với trạng thái loading
                    Button(
                        onClick = { login() },
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .width(280.dp)
                            .padding(start = 70.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                color = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        } else {
                            Text(text = "SIGN IN")
                        }
                    }

                    // Hiển thị thông báo nếu có lỗi
                    if (message.isNotEmpty()) {
                        Text(
                            text = message,
                            color = Color.Red,
                            modifier = Modifier.padding(top = 20.dp)
                        )
                    }

                    Row(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Don't have an account? ",
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 3.dp)
                        )
                        Text(
                            text = "SIGN UP",
                            fontSize = 18.sp,
                            color = Color.Black,
                            modifier = Modifier.clickable { navController.navigate("dang_ky") }
                        )
                    }
                }
            }
        }
    }
}
