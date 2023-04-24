package com.tripbook.suyeontoyproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tripbook.data.model.Users
import com.tripbook.data.repository.Repository
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val result = MutableLiveData<List<Users>>()
    val result2 : LiveData<List<Users>>
        get() = result

    fun getAllData() = viewModelScope.launch {
        result.value =  repository.getAllData()
    }
}