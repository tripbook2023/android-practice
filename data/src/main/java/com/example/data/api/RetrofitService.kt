package com.example.data.api

import com.example.data.model.ItemEntity
import com.example.domain.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("/users")
    suspend fun getAllItem(): List<ItemEntity>

    @GET("/users/{login}")
    suspend fun getItem(@Path("login") login: String): ItemEntity

}
