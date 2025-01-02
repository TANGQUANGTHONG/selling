package com.example.kotlin

import android.annotation.SuppressLint

//fun main(){
//    print("Nhập điểm 15p: ")
//    val a = readln().toInt()
//    print("Nhập điểm giữa kỳ: ")
//    val b = readln().toInt()
//    print("Nhập điểm cuối kỳ: ")
//    val c = readln().toInt()
//    val sum = (a + b * 2 + c * 3) / 6
//    print("Tổng là: $sum")
//    if(sum >= 9.5 ){
//        print("xếp loại xx")
//    }else if(sum >= 8){
//        print("xếp loại giỏi")
//    }else if(6 <= sum) {
//        print("xếp loại khá")
//    }else if(sum >= 4) {
//        print("xếp loại trung bình")
//    }else if(0<= sum ) {
//        print("xếp loại khá")
//    }
//
//}

@SuppressLint("SuspiciousIndentation")
fun main(){
  val phi_hang_thang = 75000
    var ketqua = 0
  print("nhập số phút đã dùng: ")
  val Tong = readln().toInt()
    if (Tong <= 50) {
      ketqua =   Tong * 700 + 75000
        print("Tổng là: $ketqua")
    }else if (Tong >  100 && Tong <= 150){
        ketqua = (Tong - 100 ) * 500 + 110000
        print("Tổng là: $ketqua")
    }else if (Tong > 150){
        ketqua =  (Tong - 150 ) * 300 + 135000
        print("Tổng là: $ketqua")
    }

}