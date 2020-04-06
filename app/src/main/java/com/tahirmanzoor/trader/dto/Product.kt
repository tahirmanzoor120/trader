/*
 *  Product Data Class Version 1.0
 */

package com.tahirmanzoor.trader.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    var productId: Long = 0, // Default Value

    @ColumnInfo(name = "product_name")
    var productName: String,

    var manufacturer: String,

    var batch: String,

    @Embedded
    var packing: Packing,

    var mfg: String,

    var exp: String,

    @ColumnInfo(name = "retail_price")
    var retailPrice: Double = 0.0,

    @ColumnInfo(name = "sale_price")
    var salePrice: Double = 0.0,

    @ColumnInfo(name = "purchase_price")
    var purchasePrice: Double = 0.0,

    var quantity: Int = 0,

    @ColumnInfo(name = "min_stock")
    var minStock: Int = 0
)

data class Packing(
    @ColumnInfo(name = "packing_type")
    var packingType: String,

    var packing: String
)
