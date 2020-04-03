package com.tahirmanzoor.trader.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tahirmanzoor.trader.R
import com.tahirmanzoor.trader.dto.Product

class ProductListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var products = emptyList<Product>() // Cached copy of products

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productDescription: TextView = itemView.findViewById(R.id.ls_product_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productView = inflater.inflate(R.layout.fragment_product, parent, false)
        return ProductViewHolder(productView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        val builder = StringBuilder()
        builder.append(position + 1).append(" : ").append(product.productName).append(" (")
            .append(product.manufacturer).append(") ")
            .append(product.packing.packing)

        holder.productDescription.text = builder.toString()
    }

    internal fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}