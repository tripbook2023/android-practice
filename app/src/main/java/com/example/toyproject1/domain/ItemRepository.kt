package com.example.toyproject1.domain

import androidx.lifecycle.LiveData
import com.example.toyproject1.data.model.ItemEntity
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getAllItem(): Flow<List<ItemEntity>>//: Flow<List<ItemEntity>> // 반환 형식도 적어야 함
}