package com.example.toyproject1.domain.usecase

import android.util.Log
import com.example.toyproject1.data.ItemRepositoryImpl
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.domain.ItemRepository
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// @Scope 지정: GetItemUseCase 인스턴스 사용 범위
class GetItemUseCase @Inject constructor(private val repository: ItemRepository) {

    fun execute(): Flow<List<ItemEntity>>{
        val itemList = repository.getAllItem()
        Log.d("GetItemUseCase", itemList.toString())
        return itemList
    }

    // invoke를 사용하면 호출부에서 메소드 이름 대신 클래스 이름만으로 호출이 가능하다.
    operator fun invoke(){

    }
}