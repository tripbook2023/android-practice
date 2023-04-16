package com.tripbook.suyeontoyproject.model

import com.squareup.moshi.Json

data class Users (
    @Json(name="login") val login : String,
    @Json(name="id") val id : String,
    @Json(name="avatar_url") val avatar_url : String
)


