package com.example.toyproject1.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item (
    @Json(name = "id")
    val id: String,
    @Json(name = "avatar_url")
    val avatarUrl: String,
    @Json(name = "login")
    val login: String
) : Parcelable