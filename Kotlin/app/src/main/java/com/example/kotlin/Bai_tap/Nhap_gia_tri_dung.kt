import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun TroChoiPhapTinhScreen() {
    // Trạng thái của trò chơi
    var so1 by remember { mutableStateOf("1") }
    var so2 by remember { mutableStateOf("2") }
    var ketQua by remember { mutableStateOf("3") }
    var randomViTri by remember { mutableStateOf(Random.nextInt(1, 5)) }  // Random ô trống (1 đến 4 vì thêm dấu +)
    var nhapLieu by remember { mutableStateOf(TextFieldValue("")) }
    var diem by remember { mutableStateOf(0) }
    var troChoiKetThuc by remember { mutableStateOf(false) }

    val dauCong = "+"

    fun kiemTraKetQua() {
        when (randomViTri) {
            1 -> if (nhapLieu.text == so1) {
                diem++
                randomViTri = Random.nextInt(1, 5) // Random ô trống mới (1 đến 4 vì có thêm dấu +)
                nhapLieu = TextFieldValue("")
            } else {
                troChoiKetThuc = true // Trò chơi kết thúc
            }
            2 -> if (nhapLieu.text == dauCong) {
                diem++
                randomViTri = Random.nextInt(1, 5)
                nhapLieu = TextFieldValue("")
            } else {
                troChoiKetThuc = true
            }
            3 -> if (nhapLieu.text == so2) {
                diem++
                randomViTri = Random.nextInt(1, 5)
                nhapLieu = TextFieldValue("")
            } else {
                troChoiKetThuc = true
            }
            4 -> if (nhapLieu.text == ketQua) {
                diem++
                randomViTri = Random.nextInt(1, 5)
                nhapLieu = TextFieldValue("")
            } else {
                troChoiKetThuc = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Phần giải nghĩa
        Text(
            text = "Giải nghĩa:",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Phép tính: 1 + 2 = 3",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Random ẩn thông tin tại vị trí thứ: $randomViTri",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SoO(
                so = so1,
                isEditable = randomViTri == 1,
                nhapLieu = nhapLieu,
                onValueChange = { nhapLieu = it }
            )
            DauO(
                dau = dauCong,
                isEditable = randomViTri == 2,
                nhapLieu = nhapLieu,
                onValueChange = { nhapLieu = it }
            )
            SoO(
                so = so2,
                isEditable = randomViTri == 3,
                nhapLieu = nhapLieu,
                onValueChange = { nhapLieu = it }
            )
            Text(
                text = "=",
                fontSize = 24.sp
            )
            SoO(
                so = ketQua,
                isEditable = randomViTri == 4,
                nhapLieu = nhapLieu,
                onValueChange = { nhapLieu = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nút kiểm tra kết quả
        Button(
            onClick = {
                kiemTraKetQua()
            },
            enabled = !troChoiKetThuc
        ) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(16.dp))


        if (troChoiKetThuc) {
            Text(text = "Trò chơi kết thúc! Điểm của bạn: $diem")
        } else {
            Text(text = "Điểm hiện tại: $diem")
        }
    }
}


@Composable
fun SoO(
    so: String,
    isEditable: Boolean,  
    nhapLieu: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(60.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
    ) {
        if (isEditable) {
            TextField(
                value = nhapLieu,
                onValueChange = onValueChange,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                singleLine = true,
                maxLines = 1
            )
        } else {
            Text(text = so, fontSize = 24.sp)
        }
    }
}


@Composable
fun DauO(
    dau: String,
    isEditable: Boolean,
    nhapLieu: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(60.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
    ) {
        if (isEditable) {
            TextField(
                value = nhapLieu,
                onValueChange = onValueChange,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                singleLine = true,
                maxLines = 1
            )
        } else {
            Text(text = dau, fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTroChoiPhapTinhScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        TroChoiPhapTinhScreen()
    }
}
