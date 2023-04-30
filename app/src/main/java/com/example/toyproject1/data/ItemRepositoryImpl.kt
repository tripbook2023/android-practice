package com.example.toyproject1.data

import android.util.Log
import com.example.toyproject1.data.api.RetrofitService
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.domain.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(private val retrofitService:RetrofitService): ItemRepository {

    /*
        - remoteDataSource처럼 아예 api 인터페이스를 구현한 파일
        - localDataSource는 Dao를 구현한 파일
        두 파일을 따로 작성하는 경우도 있다.
    */

    override fun getAllItem(): Flow<List<ItemEntity>>  = flow{
        val items = retrofitService.getAllItem()
        Log.d("RepositoryImpl", items.toString())
        emit(items)
    }
}