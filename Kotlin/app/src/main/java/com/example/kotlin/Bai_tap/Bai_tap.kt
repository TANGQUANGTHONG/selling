package com.example.kotlin.Game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.floor
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameApp()
        }
    }
}

@Preview
@Composable
fun GameApp() {

    var so1 by remember { mutableStateOf(0) }
    var so2 by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf(0) }
    var missingIndex by remember { mutableStateOf(0) }
    var userInput by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    // Random phép tính mới
    fun randomizeValues() {
        so1 = Random.nextInt(1, 10)
        so2 = Random.nextInt(1, 10)
        result = so1 + so2
        missingIndex = Random.nextInt(0, 3) // Random vị trí ẩn (0 là so1, 1 là so2, 2 là result)
        userInput = ""
        message = ""
    }

    // Hàm kiểm tra đáp án
    fun checkAnswer() {
        val userAnswer = userInput.toIntOrNull()
        if (userAnswer == null) {
            message = "Vui lòng nhập số hợp lệ!"
            return
        }

        when (missingIndex) {
            0 -> if (userAnswer == so1) message = "Chính xác! Random số mới!" else message = "Sai rồi! Thử lại."
            1 -> if (userAnswer == so2) message = "Chính xác! Random số mới!" else message = "Sai rồi! Thử lại."
            2 -> if (userAnswer == result) message = "Chính xác! Random số mới!" else message = "Sai rồi! Thử lại."
        }

        if (message == "Chính xác! Random số mới!") {
            randomizeValues()
        }
    }

    LaunchedEffect(Unit) {
        randomizeValues() // Khởi tạo phép tính đầu tiên khi app load
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(text = "Giải nghĩa:", modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Phép tính: ${if (missingIndex != 0) so1 else "?"} + ${if (missingIndex != 1) so2 else "?"} = ${if (missingIndex != 2) result else "?"}")
        Text(text = "Random ẩn thông tin tại vị trí thứ: ${missingIndex + 1}")

        // Ô nhập giá trị người dùng điền vào
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Điền giá trị") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Hiển thị thông báo
        Text(text = message, modifier = Modifier.padding(top = 16.dp))
    }
}