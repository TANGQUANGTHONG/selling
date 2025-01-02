package com.example.kotlin.CodeKotlin.Lab_1

fun main(){
    print("Nhập số tiền của laptop: ")
    val so_tien_laptop = readln().toInt()

    val laiSuat = 0.01

    val so_tien_goc_can_tra_moi_thang = so_tien_laptop/6

    var so_tien_goc_con_lai = so_tien_laptop

    println("Số tiền cần trả trong 6 tháng là: ")

    for( thang in 1..6){
        val tienLaiThangNay = so_tien_goc_con_lai * laiSuat

        val tongTienPhaiTra = so_tien_goc_can_tra_moi_thang + tienLaiThangNay

        so_tien_goc_con_lai -= so_tien_goc_can_tra_moi_thang

        println("Tháng:$thang | tiền gốc còn lại là: $so_tien_goc_con_lai |số tiền gốc cần phải trả: $so_tien_goc_can_tra_moi_thang| tiền lãi trong thàng này: $tienLaiThangNay | số tiền cần phải trả: $tongTienPhaiTra")


    }

}