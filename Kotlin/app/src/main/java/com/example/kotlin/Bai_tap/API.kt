//package com.example.kotlin.Bai_tap
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//
//// Data class định nghĩa đối tượng Category
//data class Category(
//    val cateID: Int,
//    val cateName: String
//)
//
//// Interface định nghĩa API
//interface ApiService {
//    @GET("list-category.php")
//    suspend fun getCategory(): List<Category>
//}
//
//// Object để khởi tạo Retrofit
//object RetrofitInstance {
//    private const val BASE_URL = "vieclam.shop/"
//
//    val api: ApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}
