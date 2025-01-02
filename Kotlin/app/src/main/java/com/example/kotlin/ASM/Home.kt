import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.kotlin.ASM.ApiClient
import com.example.kotlin.ASM.Product
import com.example.kotlin.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    // Danh sách tiêu đề
    val listTitle = listOf(
        Pair("Popular", R.drawable.star),
        Pair("Chair", R.drawable.chair),
        Pair("Table", R.drawable.table),
        Pair("Armchair", R.drawable.sofa),
        Pair("Bed", R.drawable.bed),
        Pair("Lamp", R.drawable.lamp),
    )

    // Biến trạng thái để lưu danh sách sản phẩm từ API
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var filteredProducts by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Khởi tạo coroutine scope
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val response = ApiClient.apiService.getProducts()
            isLoading = false
            if (response.isSuccessful) {
                products = response.body() ?: emptyList()
                filteredProducts = products

                // In ra danh sách sản phẩm để kiểm tra
                products.forEach { product ->
                    Log.d("Product Info", "ID: ${product._id},IMG: ${product.imageUrl}, Name: ${product.name}, Price: ${product.price}")
                }
            } else {
                errorMessage = "Lỗi: ${response.message()}"
            }
        }
    }
    // Biến trạng thái để lưu chỉ mục của mục tiêu đề được chọn
    val selectedIndex = remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Hàng chứa tiêu đề và nút điều hướng
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.navigate("Cart") }) {
                    Image(
                        painter = painterResource(id = R.drawable.shop),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(25.dp)
                    )
                }

                Text(
                    text = "MAKE HOME\n BEAUTIFUL",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                IconButton(onClick = { navController.navigate("Cart") }) {
                    Image(
                        painter = painterResource(id = R.drawable.kinh_lup),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

            // LazyRow chứa các tiêu đề
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(listTitle) { item ->
                    val index = listTitle.indexOf(item)  // Lấy chỉ mục của mục hiện tại

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(60.dp)
                            .background(
                                if (selectedIndex.value == index) Color.Black else Color.LightGray,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable {
                                // Khi người dùng chọn, cập nhật chỉ mục
                                selectedIndex.value = index

                                // Lọc sản phẩm dựa trên tiêu đề được chọn
                                filteredProducts = if (index == 0) {
                                    products // Hiển thị tất cả nếu chọn "Popular"
                                } else {
                                    products.filter { product ->
                                        // Ví dụ: Lọc sản phẩm theo loại
                                        product.name.contains(item.first, ignoreCase = true)
                                    }
                                }
                            }
                    ) {
                        Image(
                            painter = painterResource(id = item.second),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(25.dp),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = item.first,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize(),
                            textAlign = TextAlign.Center,
                            fontWeight = if (selectedIndex.value == index) FontWeight.Bold else FontWeight.Normal,  // In đậm nếu được chọn
                            color = if (selectedIndex.value == index) Color.White else Color.Black  // Đổi màu chữ nếu được chọn
                        )
                    }
                }
            }

            // Hiển thị thông báo lỗi nếu có
            errorMessage?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // Hiển thị khi đang tải
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            } else {
                // LazyVerticalGrid chứa các sản phẩm đã lọc
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(filteredProducts) { product ->
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .clickable {
                                    // Chuyển ID của sản phẩm sang màn hình chi tiết
                                    navController.navigate("ChiTietSanPham/${product._id}")
                                }
                        ) {
                            AsyncImage(
                                model = product.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(150.dp)
                                    .width(150.dp)
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop,
                                placeholder = painterResource(R.drawable.ech_ki_dieu),  // Hiển thị khi ảnh đang tải
                                error = painterResource(R.drawable.rua),  // Hiển thị khi tải ảnh thất bại
                            )
                            Text(
                                text = product.name,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start
                            )
                            Text(
                                text = product.price.toString(),
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
    }
}

