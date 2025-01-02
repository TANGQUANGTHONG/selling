//package com.example.kotlin.Bai_tap
//
//import android.util.Log
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.kotlin.ASM.Product
//import com.example.kotlin.ASM.RetrofitInstance
//import kotlinx.coroutines.launch
//
//class ViewModelApp : ViewModel() {
////    private val _categorys = mutableStateOf<List<Category>>(emptyList())
////    val categorys: State<List<Category>> = _categorys
//
//    private val _product = mutableStateOf<List<Product>>(emptyList())
//    val product: State<List<Product>> = _product
//
////    fun getCategoryViewModel() {
////        viewModelScope.launch {
////            try {
////                _categorys.value = RetrofitInstance.api.
////            } catch (e: Exception) {
////                Log.d("Error", e.toString())
////            }
////        }
////    }
//
//
//    fun getProduct() {
//        viewModelScope.launch {
//            try {
//                _product.value = RetrofitInstance.api.getProducts()
//            } catch (e: Exception) {
//                Log.d("Error", e.toString())
//            }
//        }
//    }
//}
