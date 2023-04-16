package com.tripbook.suyeontoyproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tripbook.suyeontoyproject.model.Users
import com.tripbook.suyeontoyproject.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //val retrofitInstance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val repository = Repository()

    private val result = MutableLiveData<List<Users>>()
    val result2 : LiveData<List<Users>>
        get() = result

    fun getAllData() = viewModelScope.launch {
        result.value =  repository.getAllData()
    }
}