package com.tripbook.data.repository

import com.tripbook.data.api.MyApi
import com.tripbook.data.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllApi()
}