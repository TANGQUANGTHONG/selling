package com.example.kotlin.Bai_tap.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import code_sms
import com.example.kotlin.ASM.MainScreen
import com.example.kotlin.thong_tin


class Main : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Surface(modifier = Modifier,
                color = Color.White) {
                lab7ne()
            }

        }
    }
}

@Composable
fun lab7ne(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "code_sms"
    ){

        composable("dang_ky_sdt"){
            dang_ky_sdt(navController)
        }
        composable("code_sms"){
            code_sms(navController)
        }
        composable("tao_pass"){
            tao_pass(navController)
        }
        composable("thong_tin"){
            thong_tin(navController)
        }
    }
}


@Preview
@Composable
fun previewlab7() {
    lab7ne()
}
