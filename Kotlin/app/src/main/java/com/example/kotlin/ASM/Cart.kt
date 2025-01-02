package donad.vn.kotlin.ASM

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.material3.TextFieldDefaults
import androidx.navigation.NavHostController
import androidx.compose.material3.TextFieldColors


import com.example.kotlin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(navHostController: NavHostController) {
    var promoCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .width(14.dp)
                    .height(14.dp)
            )
            Text(text = "My cart", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 14.dp)
        ) {
            Box(modifier = Modifier) {
                AsyncImage(
                    model = "https://bizweb.dktcdn.net/100/429/325/products/o1cn012shzpl1psjdbflbf7-2214670281839-0-cib.jpg?v=1696941369057",
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Minimal stand", color = Color.Gray, fontSize = 14.sp)
                        Image(
                            painter = painterResource(id = R.drawable.delete),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                    Text(text = "$ 25.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "+", color = Color.Black)
                        }
                        Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "-", color = Color.Black)
                        }
                    }
                }
            }
        }
        // Đường kẻ ngang
        Divider(
            color = Color.Gray, // Màu xám
            thickness = 0.5.dp,   // Độ dày của đường
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 14.dp)
        ) {
            Box(modifier = Modifier) {
                AsyncImage(
                    model = "https://i.etsystatic.com/50202702/r/il/e7fa81/6116251090/il_794xN.6116251090_im88.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Coffee table", color = Color.Gray, fontSize = 14.sp)
                        Image(
                            painter = painterResource(id = R.drawable.delete),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                    Text(text = "$ 20.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "+", color = Color.Black)
                        }
                        Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "-", color = Color.Black)
                        }
                    }
                }
            }
        }
        // Đường kẻ ngang
        Divider(
            color = Color.Gray, // Màu xám
            thickness = 0.5.dp,   // Độ dày của đường
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 14.dp)
        ) {
            Box(modifier = Modifier) {
                AsyncImage(
                    model = "https://i.etsystatic.com/26514007/r/il/b310e5/3653094048/il_570xN.3653094048_d2ul.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Minimal desk", color = Color.Gray, fontSize = 14.sp)
                        Image(
                            painter = painterResource(id = R.drawable.delete),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                    Text(text = "$ 50.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "+", color = Color.Black)
                        }
                        Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "-", color = Color.Black)
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Column{
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = promoCode, // Sử dụng biến trạng thái
                        onValueChange = {
                            promoCode = it
                        }, // Cập nhật giá trị khi người dùng nhập liệu
                        placeholder = { Text(text = "Enter your promo code") }, // Thêm placeholder cho TextField
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFe7e7e7), // Màu nền khi không được chọn
                            focusedContainerColor = Color(0xFFe7e7e7),   // Màu nền khi được chọn
                            focusedIndicatorColor = Color.Transparent,   // Ẩn viền khi được chọn
                            unfocusedIndicatorColor = Color.Transparent  // Ẩn viền khi không được chọn
                        )
                    )

                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .width(50.dp)
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black // Đặt màu nền của nút thành màu đen
                        ),
                        shape = RoundedCornerShape(5.dp) // Bo tròn 10dp
                    ) {
                        Text(text = ">", color= Color.White)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total:", color = Color.Gray, fontSize = 20.sp)
                    Text(
                        text = "$ 95.00",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { navHostController.navigate("Pay") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black // Đặt màu nền của nút thành màu đen
                    ),
                    shape = RoundedCornerShape(10.dp) // Bo tròn 10dp
                ) {
                    Text(text = "Check out", color = Color.White)
                }
            }
        }
    }
}