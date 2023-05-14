package com.example.data.model

import com.squareup.moshi.Json
import org.json.JSONObject

data class RepositoryEntity (
    @Json(name =  "total_count")
    val total_count: String
)