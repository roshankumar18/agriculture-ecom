package com.example.agroic.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agroic.R
import com.example.agroic.databinding.ItemLayoutBinding
import com.example.agroic.model.seeds.SeedsProductItem

class ProductAdapter(private val products: List<SeedsProductItem>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayoutBinding.bind(itemView)
        fun bind(product: SeedsProductItem) {
            Log.d("test", "bind: ")
            binding.productName.text = product.name
            binding.productPrice.text = product.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ProductHolder(itemView)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(products[position])
    }

}