package com.tripbook.suyeontoyproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tripbook.suyeontoyproject.databinding.TextApiBinding
import com.tripbook.data.model.Users
import dagger.hilt.android.AndroidEntryPoint


class CustomAdapter(val context: Context, val dataSet : List<Users>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

      class ViewHolder(private val binding: TextApiBinding) : RecyclerView.ViewHolder(binding.root) {
          fun bind(user : Users) {
              binding.user = user
              binding.executePendingBindings()
          }
          @BindingAdapter("imgSrc")
          fun bindIamgeView(imageView: ImageView, data: String?) {
              if (!data.isNullOrEmpty()) {
                  Glide.with(imageView.context)
                      .load(data)
                      .into(imageView)
              }
          }

      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = TextApiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = dataSet[position]
        holder.bind(user)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}

