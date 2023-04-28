package com.example.toyproject1.domain.usecase

import android.util.Log
import com.example.toyproject1.data.ItemRepositoryImpl
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.domain.ItemRepository
import kotlinx.coroutines.flow.Flow

class GetItemUseCase(){ //private val repository: ItemRepository) {

    private val repository = ItemRepositoryImpl()

    fun execute(): Flow<List<ItemEntity>>{
        val itemList = repository.getAllItem()
        Log.d("GetItemUseCase", itemList.toString())
        return itemList
    }

    // invoke를 사용하면 호출부에서 메소드 이름 대신 클래스 이름만으로 호출이 가능하다.
    operator fun invoke(){

    }
}