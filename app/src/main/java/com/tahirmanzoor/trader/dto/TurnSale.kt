package com.tahirmanzoor.trader.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tahirmanzoor.trader.utils.Day

@Entity(tableName = "cusomer_turn")
data class CustomerTurn(
    @PrimaryKey(autoGenerate = true)
    var trunId: Long,

    @ColumnInfo(name = "turn_name")
    var turnName: String,

    var turnDay: Day
)

@Entity(primaryKeys = ["customerId", "trunId"])
data class TurnCustomerCrossRef(
    val customerId: Long,
    val trunId: Long
)
