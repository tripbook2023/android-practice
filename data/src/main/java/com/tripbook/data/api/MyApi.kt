package com.tripbook.data.api

import com.tripbook.data.model.Users
import retrofit2.http.GET

interface MyApi {

    @GET("https://api.github.com/users")
    suspend fun getAllApi() : List<Users>
}