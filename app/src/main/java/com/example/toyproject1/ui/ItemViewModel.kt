package com.example.toyproject1.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.data.api.RetrofitApi
import com.example.toyproject1.domain.usecase.GetItemUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemViewModel(private val getItemUseCase: GetItemUseCase): ViewModel() {

    /*
    ViewModel 컴포넌트
       0. UseCase 매개변수
       1. UI에서 사용할 데이터 변수(_, access 가능)
       2. UseCase에서 데이터 불러오는 함수
    */

    private val _allData = MutableStateFlow<List<ItemEntity>>(listOf())
    val allData: StateFlow<List<ItemEntity>> get() = _allData

    init {
        getAllData()
    }

    private fun getAllData(){
        viewModelScope.launch(){
            getItemUseCase.execute().collect{
                Log.d("ItemViewModel", it.toString())
                _allData.value = it
            }
        }
    }
}

class ItemViewModelFactory(private val getItemUseCase: GetItemUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(ItemViewModel::class.java)){
            ItemViewModel(getItemUseCase) as T
        } else{
            throw IllegalArgumentException()
        }
    }
}