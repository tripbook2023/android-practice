package com.example.toyproject1.data.api

import com.example.toyproject1.data.model.ItemEntity
import retrofit2.http.GET

//private const val BASE_URL = "https://api.github.com/"
//
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()

interface RetrofitService {
    @GET("/users")
    suspend fun getAllItem(): List<ItemEntity>
}

//object RetrofitApi{
//    val retrofitService: RetrofitService by lazy {
//        retrofit.create(RetrofitService::class.java)
//    }
//}