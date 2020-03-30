package com.tahirmanzoor.trader.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tahirmanzoor.trader.utils.MobileNo

@Entity
data class Customer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_id")
    var customerId: Long,

    @ColumnInfo(name = "customer_name")
    var customerName: String,

    @ColumnInfo(name = "shop_name")
    var shopName: String,

    @Embedded
    var address: ShopAddress,

    @Embedded
    var mobileNo: MobileNo,

    var balance: Double
)

data class ShopAddress(
    @ColumnInfo(name = "shop_no")
    var shopNo: String,

    @ColumnInfo(name = "street_name")
    var streetName: String,

    var area: String,
    var city: String
)
