//package com.example.kotlin.Bai_tap
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.viewmodel.compose.viewModel
//
//@Composable
//fun Greeting(viewModel: ViewModelApp = viewModel()) {
//    val categorys by viewModel.categorys
//
//    LaunchedEffect(Unit) {
//        viewModel.getCategoryViewModel()
//    }
//
//    if (categorys.isEmpty()) {
//        // Hiển thị thông báo nếu không có dữ liệu
//        Text(text = "Loading categories...")
//    } else {
//        LazyColumn {
//            items(categorys) { item ->
//                Card {
//                    Column {
//                        Text(text = item.cateName)
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//@Preview
//@Composable
//fun Preview_API(){
//Greeting()
//}