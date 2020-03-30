package com.tahirmanzoor.trader.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "recovery_sale")
data class RecoverySale(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recovery_sale_id")
    var recoverySaleId: Long,

    @ColumnInfo(name = "customer_id")
    var customerId: Long,

    @ColumnInfo(name = "last_sale_invoice")
    var lastSaleInvoice: InvoiceSale,

    @ColumnInfo(name = "recovery_date")
    var recoveryDate: Date,

    @ColumnInfo(name = "recovery_amount")
    var recoveryAmount: Double,

    @ColumnInfo(name = "balance_before")
    var balanceBefore: Double,

    @ColumnInfo(name = "balance_after")
    var balanceAfter: Double
)