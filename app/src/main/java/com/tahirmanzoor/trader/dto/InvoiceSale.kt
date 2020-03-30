package com.tahirmanzoor.trader.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sale_invoice")
data class InvoiceSale(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "invoice_id")
    var invoiceId: Long,

    @Embedded
    @ColumnInfo(name = "product_line")
    var productLine: ProductLine,

    var subtotal: Double,

    @ColumnInfo(name = "sales_tax")
    var saleTax: Double,

    var discount: Double,
    var total: Double
)

data class ProductLine(
    var product: Product,
    var quantity: Int,

    @ColumnInfo(name = "free_items")
    var freeItems: Int,

    var percentage: Double
)