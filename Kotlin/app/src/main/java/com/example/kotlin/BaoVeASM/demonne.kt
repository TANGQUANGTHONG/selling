package com.example.kotlin.BaoVeASM

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BeverageScreen(navController: NavHostController) {
    val beverages = listOf(
        Beverage("Strawberry Punch", "$35", "$25", com.example.kotlin.R.drawable.rua),
        Beverage("Lemonade", "", "$25", com.example.kotlin.R.drawable.rua),
        Beverage("Chocolate", "$35", "$25", com.example.kotlin.R.drawable.rua),
        Beverage("Whisky", "", "$25", com.example.kotlin.R.drawable.rua),
        Beverage("Chocolate Bakery", "$35", "$25", com.example.kotlin.R.drawable.rua),
        Beverage("Fruit Punch", "", "$25", com.example.kotlin.R.drawable.rua)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF33907C))
                .padding(16.dp)
        ) {
            Text(
                text = "Beverages",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp),
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                ButtonWithIcon(onClick = { /* Sort by action */ }, text = "Sort by", iconResId = com.example.kotlin.R.drawable.rua)
                ButtonWithIcon(onClick = { /* Location action */ }, text = "Location", iconResId = com.example.kotlin.R.drawable.rua)
                ButtonWithIcon(onClick = { /* Category action */ }, text = "Category", iconResId = com.example.kotlin.R.drawable.rua)
            }
        }

        // Content section with white background
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(beverages) { beverage ->
                    BeverageCard(beverage)
                }
            }
        }
    }
}

@Composable
fun BeverageCard(beverage: Beverage) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = beverage.image),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(beverage.name, fontWeight = FontWeight.Bold)
            Text(beverage.oldPrice, textDecoration = TextDecoration.LineThrough, color = Color.Gray)
            Text(beverage.newPrice, color = Color(0xFF13B58C), fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun ButtonWithIcon(onClick: () -> Unit, text: String, iconResId: Int) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier
            .padding(8.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,

        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(10.dp),
                tint = Color(0xFF33907C)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text, color = Color(0xFF33907C))
        }
    }
}

data class Beverage(val name: String, val oldPrice: String, val newPrice: String, val image: Int)
