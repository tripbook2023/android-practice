package com.example.toyproject1

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject1.network.Item


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Item>?){
    val adapter = recyclerView.adapter as RecyclerViewAdapter
    adapter.dataList = data
    adapter.notifyDataSetChanged()
}

@BindingAdapter("imgSrc", "provideView")
fun bindImageView(imgView: ImageView, data: String, view: View){
    Glide.with(view)
        .load(data)
        .into(imgView)
}

@BindingAdapter("imgSrc", "provideView")
fun bindImageFragment(imgView: ImageView, data: String, view: Fragment){
    Glide.with(view)
        .load(data)
        .into(imgView)
}