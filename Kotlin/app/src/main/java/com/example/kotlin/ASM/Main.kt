package com.example.kotlin.ASM


import Home
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asm.ChiTietSanPham
import donad.vn.kotlin.ASM.Cart
import donad.vn.kotlin.ASM.Pay

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "man_hinh_chao"
    ) {
        composable("man_hinh_chao") {
            HomeScreen(navController)
        }
        composable("dang_nhap") {
            dang_nhap(navController)
        }
        composable("Homene") {
            Home(navController)
        }
        composable("dang_ky") {
            dang_ky(navController)
        }
        composable("thong_bao") {
            thongBao(navController)
        }
        composable("Cart") {
            Cart(navController)
        }
        composable("Pay") {
            Pay(navController)
        }
        composable("ChiTietSanPham/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ChiTietSanPham(navController, productId)
        }




    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
