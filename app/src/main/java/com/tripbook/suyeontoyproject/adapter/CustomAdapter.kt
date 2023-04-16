package com.tripbook.suyeontoyproject.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tripbook.suyeontoyproject.R
import com.tripbook.suyeontoyproject.databinding.ActivityMainBinding
import com.tripbook.suyeontoyproject.databinding.TextApiBinding
import com.tripbook.suyeontoyproject.model.Users

class CustomAdapter(val context: Context, val dataSet : List<Users>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

   // class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
      class ViewHolder(private val binding: TextApiBinding) : RecyclerView.ViewHolder(binding.root) {
       // val textView : TextView = view.findViewById(R.id.textArea)
        val imageView : ImageView = binding.imageArea

          fun bind(user : Users) {
              binding.user = user
          }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = TextApiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ViewHolder(binding)

        //val view = LayoutInflater.from(parent.context).inflate(R.layout.text_api, parent, false)
        //return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = dataSet[position]
        holder.bind(user)

        Glide.with(context)
            .load(user.avatar_url)
            .into(holder.imageView)


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}

