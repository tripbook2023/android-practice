package com.example.toyproject1.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toyproject1.network.Item
import com.example.toyproject1.network.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemViewModel: ViewModel() {

    private val _allData = MutableLiveData<List<Item>>()
    val allData: LiveData<List<Item>> get() = _allData

    init {
        getAllData()
    }

    private fun getAllData(){
        RetrofitApi.retrofitService.getAllData().enqueue(object: Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if(response.isSuccessful)
                    _allData.value = response.body()
                else
                    Log.d("ViewModel" + "isNotSuccessful", response.toString())
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.d("ViewModel" + "onFailure", t.toString())
            }
        })
    }
}