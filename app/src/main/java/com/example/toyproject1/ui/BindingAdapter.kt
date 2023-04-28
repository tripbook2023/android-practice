package com.example.toyproject1.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.ui.RecyclerViewAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ItemEntity>?){
    val adapter = recyclerView.adapter as RecyclerViewAdapter
    if (data != null) {
        adapter.submitList(data)
    }
}

@BindingAdapter("imgSrc")
fun bindImageView(imgView: ImageView, data: String){
    Glide.with(imgView.context)
        .load(data)
        .into(imgView)
}
