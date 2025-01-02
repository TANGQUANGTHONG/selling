    package com.example.kotlin.ASM

    import retrofit2.Response
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory
    import retrofit2.http.Body
    import retrofit2.http.GET
    import retrofit2.http.POST
    import retrofit2.http.Path

    // Model cho sản phẩm
    data class Product(

        val name: String,
        val price: Int,
        val imageUrl: String,
        val type: String,
        val _id: String
    )

    // Request
    data class RegisterRequest(
        val Email: String,
        val Username: String,
        val Password: String
    )

    data class LoginRequest(
        val Username: String,
        val Password: String
    )

    // Response
    data class RegisterResponse(
        val message: String
    )

    data class LoginResponse(
        val message: String
    )

    // Response cho việc lấy danh sách sản phẩm
    data class ProductResponse(
        val products: List<Product>
    )

    // Interface định nghĩa các endpoint của API
    interface ApiService {
        @POST("userKotlin/register")
        suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>

        @POST("userKotlin/login")
        suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

        @GET("product/products") // Đường dẫn đến API lấy sản phẩm
        suspend fun getProducts(): Response<List<Product>>

        @GET("product/products/{id}") // Đường dẫn đến API lấy thông tin chi tiết sản phẩm theo ID
        suspend fun getProductById(@Path("id") id: String): Response<Product> // Sửa lại để thêm @Path

        @GET("product/type/{type}") // Đường dẫn đến API lọc sản phẩm theo loại
        suspend fun getProductsByType(@Path("type") type: String): Response<List<Product>> // Thêm phương thức mới
    }

    // Client để thực hiện các yêu cầu đến API
    object ApiClient {
        private const val BASE_URL = "https://api-q69y.onrender.com/"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Sử dụng Gson để parse JSON
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)
    }
