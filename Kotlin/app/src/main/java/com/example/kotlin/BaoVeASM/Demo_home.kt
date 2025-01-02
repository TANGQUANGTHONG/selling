package com.example.kotlin.BaoVeASM

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(color = Color(0xFF33907C)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Beverages",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                text = "",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )

        }
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text(text = "Search", color = Color.White) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedBorderColor = Color.White,
//                unfocusedBorderColor = Color.White
//            ),
//            shape = RoundedCornerShape(20.dp),
//            modifier = Modifier
//                .width(200.dp)
//                .padding(8.dp)
//        )

        // Product Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(6) { // Number of products
                ProductItem(
                    name = "TMA-2 HD Wireless",
                    price = "Rp. 1.500.000",
                    rating = "4.6",
                    reviews = "86 Reviews",
                    imageRes = R.drawable.rua // Replace with your product image resource
                )
            }
        }
    }
}

@Composable
fun ProductItem(
    name: String,
    price: String,
    rating: String,
    reviews: String,
    imageRes: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.LightGray)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = price, color = Color.Red, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "⭐ $rating", fontSize = 12.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = reviews, fontSize = 12.sp)
        }
    }
}
