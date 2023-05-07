package com.example.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.domain.Item
import com.example.domain.usecase.GetAllItemUseCase
import com.example.domain.usecase.GetItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val getAllItemUseCase: GetAllItemUseCase, private val getItemUseCase: GetItemUseCase): ViewModel() {

    private val _allData = MutableStateFlow<List<Item>>(listOf())
    val allData: StateFlow<List<Item>> get() = _allData

    private val _itemData = MutableStateFlow<Item>(Item("","",""))
    val itemData: StateFlow<Item> get() = _itemData

    fun requestAllData(){
        viewModelScope.launch{
            getAllItemUseCase.execute().collect{
                Log.d("ItemViewModel", it.toString())
                _allData.value = it
            }
        }
    }

    fun requestData(login: String){
        viewModelScope.launch {
            getItemUseCase.execute(login).collect(){
                Log.d("ItemViewModel", it.toString())
                _itemData.value = it
            }
        }
    }
}