package com.example.kotlin.CodeKotlin.Lab_1

fun main() {
    //tìm số đầu tiên
    print("Nhập số cần tìm vào đây: ")
    var so_a = readln().toInt()
    val so_goc = so_a
    while (so_a >= 10) {
        so_a /= 10
    }
    println("số đầu tiên: $so_a ")
// số chẵn lẻ
    if (so_a % 2 == 0) {
        println("số a là số chẵn ")
    } else {
        println("số a là số lẻ")
    }

//số giảm dần
    var a = so_goc
    var so_cuoi = a % 10
    a /= 10

    var giam_dan = true

    while (a > 0) {
        val so_ke_tiep = a % 10

        if (so_ke_tiep < so_cuoi) {
            giam_dan = false
            break
        } else {
            so_cuoi = so_ke_tiep
            a /= 10
        }
    }
    if (giam_dan) {
        print("Số a giảm dần")
    } else {
        print("Số a không giảm dần")
    }
}
