package com.example.kotlin.Bai_tap

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun list() {
    data class NhanVien(var MaNV: Int, var TenNV: String, var Tien: Int)

    var listNV = remember {
        mutableStateListOf(
            NhanVien(1, "TangQuangThong", 100000000),
            NhanVien(2, "VoTanTai", 100),
            NhanVien(3, "PhanHuuCanh", 1000000),
            NhanVien(4, "PhucThien", 200000),
            NhanVien(5, "NguyenVanABC", 1234567),
            NhanVien(6, "NguyenVanIIII", 989989898)
        )
    }

    val context = LocalContext.current

    var maNVInput by remember { mutableStateOf(TextFieldValue()) }
    var tenNVInput by remember { mutableStateOf(TextFieldValue()) }
    var tienInput by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.padding(16.dp)) {

        TextField(
            value = maNVInput,
            onValueChange = { maNVInput = it },
            label = { Text("Mã Nhân Viên") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        TextField(
            value = tenNVInput,
            onValueChange = { tenNVInput = it },
            label = { Text("Tên Nhân Viên") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        TextField(
            value = tienInput,
            onValueChange = { tienInput = it },
            label = { Text("Tiền Lương") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(onClick = {
            if (maNVInput.text.isNotEmpty() && tenNVInput.text.isNotEmpty() && tienInput.text.isNotEmpty()) {
                val maNV = maNVInput.text.toInt()
                val tenNV = tenNVInput.text
                val tien = tienInput.text.toInt()

                val existingEmployeeIndex = listNV.indexOfFirst { it.MaNV == maNV }

                if (existingEmployeeIndex >= 0) {
                    listNV[existingEmployeeIndex] = NhanVien(maNV, tenNV, tien)
                    Toast.makeText(context, "Thông tin nhân viên đã được cập nhật!", Toast.LENGTH_SHORT).show()
                } else {
                    listNV.add(NhanVien(maNV, tenNV, tien))
                    Toast.makeText(context, "Nhân viên đã được thêm!", Toast.LENGTH_SHORT).show()
                }

                maNVInput = TextFieldValue("")
                tenNVInput = TextFieldValue("")
                tienInput = TextFieldValue("")
            } else {
                Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Thêm hoặc Cập nhật Nhân Viên")
        }

        // Danh sách nhân viên
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)) {
            itemsIndexed(listNV) { index, item ->
                Card(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier
                            .clickable {
                                maNVInput = TextFieldValue(item.MaNV.toString())
                                tenNVInput = TextFieldValue(item.TenNV)
                                tienInput = TextFieldValue(item.Tien.toString())

                                Toast.makeText(context, "Tên: " + item.TenNV, Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Text(text = item.MaNV.toString())
                            Text(text = item.TenNV)
                            Text(text = item.Tien.toString())
                        }

                        Button(onClick = {

                            listNV.removeAt(index)
                            Toast.makeText(context, "Đã xóa nhân viên: " + item.TenNV, Toast.LENGTH_SHORT).show()
                        }) {
                            Text("Xóa")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewList() {
    Surface(modifier = Modifier.fillMaxSize()) {
        list()
    }
}
