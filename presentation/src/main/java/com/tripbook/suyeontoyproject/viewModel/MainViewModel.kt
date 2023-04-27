package com.tripbook.suyeontoyproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tripbook.data.model.Users
import com.tripbook.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val result = MutableLiveData<List<Users>>()
    val result2 : LiveData<List<Users>>
        get() = result

    fun getAllData() = viewModelScope.launch {
        result.value =  repository.getAllData()
    }
}