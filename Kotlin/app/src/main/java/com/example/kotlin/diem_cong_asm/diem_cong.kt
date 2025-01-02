package com.example.kotlin.diem_cong_asm

// Hàm kiểm tra số hoàn thiện
fun kiemTraSoHoanThien(n: Int): Boolean {
    var tongUocSo = 0
    var i = 1

    while (i < n) {
        if (n % i == 0) {
            tongUocSo += i
        }
        i++
    }

    return tongUocSo == n
}

fun bai2(n: Int): Boolean {
    var so_dau = 0
    var so_thu_hai = 1
    while (so_dau <= n) {
        print("$so_dau")
        var so_3  = so_dau + so_thu_hai
        so_dau = so_thu_hai
        so_3 = so_thu_hai
    }
    println()
    return true
}

fun bai3(n: Int): Boolean {
    var soGoc = n
    var soDaoNguoc = 0
    var test = n

    while (test > 0 ){
        val chuSo = test % 10
        println("$chuSo")
        soDaoNguoc = soDaoNguoc * 10 + chuSo

        test /= 10
    }
    return soGoc == soDaoNguoc
}

fun bai4(a: Int, b: Int): Boolean {
    var soA = a
    val soB = b
    var doDaiB = 1
    var tempB = soB

    // Đếm số chữ số của b
    while (tempB >= 10) {
        tempB /= 10
        doDaiB *= 10
    }

    // Kiểm tra xem b có nằm trong a hay không
    while (soA >= soB) {
        if (soA % (doDaiB * 10) == soB) {
            return true
        }
        soA /= 10
    }

    return false
}

fun main() {
    var so_n: Int

    do {
        println("Menu:")
        println("1. Kiểm tra số hoàn thiện")
        println("2. Chạy bài 2")
        println("2. Chạy bài 3")
        print("Chọn menu: ")

        so_n = readln().toInt()

        when (so_n) {
            1 -> {
                print("Nhập số để kiểm tra: ")
                val n = readln().toInt()
                if (kiemTraSoHoanThien(n)) {
                    println("$n là số hoàn thiện")
                } else {
                    println("$n không phải là số hoàn thiện")
                }
            }
            2 -> {
                println("Nhập số m thích: ")
                val n = readln().toInt()
                (bai2(n))
            }
            3 -> {
                println("Nhập số n: ")
                val n = readln().toInt()
                if(bai3(n)){
                    println("$n là số đối xứng")
                } else {
                    println("$n không phải là số đối xứng")
                }

            }
            4 -> {
                print("Nhập số a: ")
                val a = readln().toInt()
                print("Nhập số b: ")
                val b = readln().toInt()

                if (bai4(a, b)) {
                    println("Số $b nằm trong số $a")
                } else {
                    println("Số $b không nằm trong số $a")
                }
            }

            else -> {
                println("Lựa chọn không hợp lệ, vui lòng chọn lại!")
            }
        }
    } while (so_n != 0)
}
