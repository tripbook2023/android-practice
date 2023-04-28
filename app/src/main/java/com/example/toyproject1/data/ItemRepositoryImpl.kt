package com.example.toyproject1.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.toyproject1.data.api.RetrofitApi
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.domain.Item
import com.example.toyproject1.domain.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepositoryImpl: ItemRepository {

    /* 나는 일단 여기서 바로 api를 호출할거지만
        - remoteDataSource처럼 아예 api 인터페이스를 구현한 파일
        - localDataSource는 Dao를 구현한 파일
        두 파일을 따로 작성하는 경우도 있다.
    */

    override fun getAllItem(): Flow<List<ItemEntity>>  = flow{
        val items = RetrofitApi.retrofitService.getAllItem()
        Log.d("RepositoryImpl", items.toString())
        emit(items)
    }
}