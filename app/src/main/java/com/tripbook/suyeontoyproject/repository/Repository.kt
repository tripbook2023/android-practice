package com.tripbook.suyeontoyproject.repository

import com.tripbook.suyeontoyproject.api.MyApi
import com.tripbook.suyeontoyproject.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllApi()
}