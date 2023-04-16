package com.tripbook.suyeontoyproject.api

import com.tripbook.suyeontoyproject.model.Users
import retrofit2.http.GET

interface MyApi {

    @GET("https://api.github.com/users")
    suspend fun getAllApi() : List<Users>
}