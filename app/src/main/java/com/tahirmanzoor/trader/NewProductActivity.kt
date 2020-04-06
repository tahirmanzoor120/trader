package com.tahirmanzoor.trader

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.tahirmanzoor.trader.dto.Packing
import com.tahirmanzoor.trader.dto.Product
import com.tahirmanzoor.trader.model.ProductViewModel

class NewProductActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    private lateinit var productName: TextInputEditText
    private lateinit var manufacturer: TextInputEditText
    private lateinit var batch: TextInputEditText
    private lateinit var mfg: TextInputEditText
    private lateinit var exp: TextInputEditText
    private lateinit var packingType: RadioGroup
    private lateinit var packing: TextInputEditText
    private lateinit var rp: TextInputEditText
    private lateinit var tp: TextInputEditText
    private lateinit var quantity: TextInputEditText
    private lateinit var minStock: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        productName = findViewById(R.id.editText_productName)
        manufacturer = findViewById(R.id.editText_manufacturer)
        batch = findViewById(R.id.editText_batch)
        mfg = findViewById(R.id.editText_mfg)
        exp = findViewById(R.id.editText_exp)
        //packingType = findViewById(R.id.rg_packingType)
        packing = findViewById(R.id.editText_packing)
        rp = findViewById(R.id.editText_rp)
        tp = findViewById(R.id.editText_tp)
        quantity = findViewById(R.id.editText_quantity)
        minStock = findViewById(R.id.editText_min_stock)
    }

    fun save(view: View) {
        if (isDataValid()) {
            val product = Product(
                productName = productName.text.toString(),
                manufacturer = manufacturer.text.toString(),
                batch = batch.text.toString(),
                packing = Packing(
                    packingType = findViewById<RadioButton>(packingType.checkedRadioButtonId).text.toString(),
                    packing = packing.text.toString()
                ),
                mfg = mfg.text.toString(),
                exp = exp.text.toString(),
                retailPrice = rp.text.toString().toDouble(),
                purchasePrice = tp.text.toString().toDouble(),
                quantity = quantity.text.toString().toInt(),
                minStock = minStock.text.toString().toInt()
            )
            productViewModel.insert(product)
            setResult(Activity.RESULT_OK, Intent())
            finish()
        }
    }

    fun cancel(view: View) {
        setResult(Activity.RESULT_CANCELED, Intent())
        finish()
    }

    private fun isDataValid(): Boolean {
        if (TextUtils.isEmpty(productName.text)) {
            productName.error = "Name is empty."
            return false
        }
        if (manufacturer.text.isNullOrBlank()) {
            manufacturer.error = "Manufacturer is empty."
            return false
        }
        if (batch.text.isNullOrBlank()) {
            batch.error = "Batch is empty."
            return false
        }
        if (packingType.checkedRadioButtonId == -1) {
            Toast.makeText(applicationContext, "Select a packing type.", Toast.LENGTH_LONG).show()
            return false
        }
        if (packing.text.isNullOrBlank()) {
            packing.error = "Packing is empty."
            return false
        }
        if (rp.text.isNullOrBlank()) {
            rp.error = "Retail price is empty."
            return false
        }
        if (tp.text.isNullOrBlank()) {
            tp.error = "Trade Price is empty."
            return false
        }
        if (quantity.text.isNullOrBlank()) {
            quantity.error = "Quantity is empty."
            return false
        }
        return true
    }
}
