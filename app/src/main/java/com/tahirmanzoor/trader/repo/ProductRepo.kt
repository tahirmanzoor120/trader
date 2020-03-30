package com.tahirmanzoor.trader.repo

import androidx.lifecycle.LiveData
import com.tahirmanzoor.trader.dao.ProductDAO
import com.tahirmanzoor.trader.dto.Product

class ProductRepo(private val productDAO: ProductDAO) {

    val allProducts: LiveData<List<Product>> = productDAO.getAllProducts()

    suspend fun insert(product: Product) {
        productDAO.insert(product)
    }

    suspend fun delete(product: Product) {
        productDAO.delete(product)
    }

    suspend fun update(product: Product) {
        productDAO.update(product)
    }
}