package com.tahirmanzoor.trader.utils

import androidx.room.ColumnInfo

enum class Operator {
    Mobilink, Telenor, Zong, Ufone, Warid
}

data class MobileNo(
    @ColumnInfo(name = "mobile_operator")
    var operator: Operator,
    @ColumnInfo(name = "mobile_code")
    var code: String,
    @ColumnInfo(name = "mobile_number")
    var number: String
)

enum class Day {
    Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday
}