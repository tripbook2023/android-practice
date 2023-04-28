package com.example.toyproject1.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject1.databinding.ListItemBinding
import com.example.toyproject1.data.model.ItemEntity

class RecyclerViewAdapter(val clickListener: (ItemEntity) -> Unit)
    : ListAdapter<ItemEntity, RecyclerViewAdapter.ViewHolder>(DiffUtil){

    class ViewHolder(private var itemBinding: ListItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemEntity: ItemEntity){
            itemBinding.item = itemEntity
            itemBinding.executePendingBindings() // 바인딩 데이터 즉각 변경
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener(item)
        }
    }

    companion object{
        val DiffUtil = object: ItemCallback<ItemEntity>(){
            override fun areItemsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}

//class RecyclerViewAdapter(val clickListener: (ItemEntity) -> Unit)
//    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
//
//    var dataList: List<ItemEntity> = listOf()
//
//    class ViewHolder(private var itemBinding: ListItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
//        fun bind(itemEntity: ItemEntity){
//            itemBinding.item = itemEntity
//            itemBinding.executePendingBindings() // 바인딩 데이터 즉각 변경
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = dataList[position]
//        holder.bind(item)
//        holder.itemView.setOnClickListener {
//            clickListener(item)
//        }
//    }
//}