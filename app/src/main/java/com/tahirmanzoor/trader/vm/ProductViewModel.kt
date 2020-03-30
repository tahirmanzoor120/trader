package com.tahirmanzoor.trader.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tahirmanzoor.trader.db.TraderDatabase
import com.tahirmanzoor.trader.dto.Product
import com.tahirmanzoor.trader.repo.ProductRepo
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val productRepo: ProductRepo =
        ProductRepo(TraderDatabase.getInstance(application).productDAO)
    val allProducts: LiveData<List<Product>>

    init {
        allProducts = productRepo.allProducts
    }

    fun insert(product: Product) = viewModelScope.launch {
        productRepo.insert(product)
    }

    fun update(product: Product) = viewModelScope.launch {
        productRepo.update(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        productRepo.delete(product)
    }

}