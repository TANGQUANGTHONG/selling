package com.example.kotlin.CodeKotlin.Lab_1

import kotlin.math.pow

fun main() {
    do {
        print("Chọn menu: ")
        var so_n = readln().toInt()

        when (so_n) {
            1 -> println("${bai1()}")
            2 -> println("${bai2()}")
            3 -> println("${bai3()}")
            4 -> println("${bai4()}")
        }
    } while (so_n > 0)
}

fun bai1() {
    print("Nhập số n: ")
    var so_n = readln().toInt()

    for (pham_vi in 1..so_n) {
        println("$pham_vi")
    }
}

fun bai2() {
    print("Nhập số n: ")
    var so_n = readln().toInt()

    print("Số chẵn là: ")

    for (so_chan in 1..so_n) {
        if (so_chan % 2 == 0) {
            print("$so_chan ")
        }
    }
}

fun bai3() {
    print("Nhập số n: ")
    var so_n = readln().toInt()

    print("Số lẻ không chia hết cho 3 là: ")

    for (so_le in 1..so_n) {
        if (so_le % 2 != 0 && so_le % 3 != 0) {
            print("$so_le ")
        }
    }
}

fun bai4() {
    print("Nhập số n: ")
    var so_n = readln().toInt()

    // S1
    var sumS1 = 0
    for (a in 1..so_n) {
        sumS1 += a
    }

    // S2
    var sumS2 = 0
    for (b in 1..so_n) {
        if (b % 2 == 0) {
            sumS2 += b
        } else {
            sumS2 -= b
        }
    }

    // S3
    var S3 = 0.0
    for (c in 1..so_n) {
        S3 += c.toDouble() / (c + 1).toDouble()
    }
    val tongS3 = S3.toFloat()

    // S4
    print("Nhập số thực x: ")
    val x = readln().toDouble()
    val S4 = x.pow(so_n)


    val sumDigits = sumOfDigits(so_n)


    println("S1 = $sumS1")
    println("S2 = $sumS2")
    println("S3 = $tongS3")
    println("S4 = $x^$so_n = $S4")
    println("Tổng các chữ số của $so_n là: $sumDigits")
}


fun sumOfDigits(n: Int): Int {
    return n.toString().map { it.toString().toInt() }.sum()
}

