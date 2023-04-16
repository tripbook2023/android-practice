package com.example.toyproject1

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject1.network.Item


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Item>){
    val adapter = recyclerView.adapter as RecyclerViewAdapter
    adapter.dataList = data
    adapter.notifyItemRangeInserted(0, data.size)
}

@BindingAdapter("imgSrc")
fun bindImageView(imgView: ImageView, data: String){
    Glide.with(imgView.context)
        .load(data)
        .into(imgView)
}
