package com.example.agroic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agroic.R
import com.example.agroic.databinding.BannerLayoutBinding

class BannerAdapter( private val images: List<String>):RecyclerView.Adapter<BannerAdapter.BannerHolder>() {

    class BannerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = BannerLayoutBinding.bind(itemView)
        fun bindImage(image:String){
            Glide.with(binding.root.context).load(image).into(binding.bannerImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.banner_layout,parent,false)
        return BannerHolder(item)

    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.bindImage(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }


}