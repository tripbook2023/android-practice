package com.example.toyproject1.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.domain.usecase.GetItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val getItemUseCase: GetItemUseCase): ViewModel() {

    /*
    ViewModel 컴포넌트
       0. UseCase 매개변수
       1. UI에서 사용할 데이터 변수(_, access 가능)
       2. UseCase에서 데이터 불러오는 함수
    */

    private val _allData = MutableStateFlow<List<ItemEntity>>(listOf())
    val allData: StateFlow<List<ItemEntity>> get() = _allData

    init {
        requestAllData()
    }

    private fun requestAllData(){
        viewModelScope.launch(){
            getItemUseCase.execute().collect{
                Log.d("ItemViewModel", it.toString())
                _allData.value = it
            }
        }
    }
}