package com.example.toyproject1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject1.databinding.ListItemBinding
import com.example.toyproject1.network.Item

class RecyclerViewAdapter(val clickListener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    var dataList: List<Item> = listOf()

    class ViewHolder(private var itemBinding: ListItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Item){
            itemBinding.item = item
            itemBinding.executePendingBindings() // 바인딩 데이터 즉각 변경
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener(item)
        }
    }
}