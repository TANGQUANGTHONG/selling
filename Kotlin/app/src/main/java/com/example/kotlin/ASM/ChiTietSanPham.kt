package com.example.asm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.kotlin.ASM.ApiClient
import com.example.kotlin.ASM.Product
import com.example.kotlin.R
import kotlinx.coroutines.launch

@Composable
fun ChiTietSanPham(navController: NavController, _id: String) {
    var product by remember { mutableStateOf<Product?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(_id) {
        coroutineScope.launch {
            val response = ApiClient.apiService.getProductById(_id) // Gọi API để lấy sản phẩm
            isLoading = false
            if (response.isSuccessful) {
                product = response.body() // Lưu thông tin sản phẩm vào biến trạng thái
            } else {
                errorMessage = "Lỗi: ${response.message()}"
            }
        }
    }

    // Hiển thị giao diện
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Hiển thị khi đang tải
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (errorMessage != null) {
            Text(text = errorMessage!!, color = Color.Red)
        } else {
            product?.let {
                AsyncImage(
                    model = it.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(440.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = it.name, // Hiển thị tên sản phẩm
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp).fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 24.sp,
                )

                Text(
                    text = "${it.price}$", // Hiển thị giá sản phẩm
                    modifier = Modifier.padding(start = 20.dp).fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        //sao
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(20.dp)
                    .height(20.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "4.5",
                modifier = Modifier
                    .padding(start = 10.dp),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            //reviews
            Text(
                text = "(50 reviews)",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Gray,
                fontSize = 14.sp,
            )
        }

        // mieu ta
        Text(
            text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
            modifier = Modifier
                .padding( start = 20.dp, end = 20.dp, top = 10.dp),
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify
        )

        // 2 btn save and Add to cart
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            // btn save
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(60.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFf3f3f3)),
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_save),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                    )
                }
            }
            // btn Add to cart
            Button(
                onClick = {navController.navigate("Cart")},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(250.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xF21D1C1C)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Add to cart",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }

    }

}


