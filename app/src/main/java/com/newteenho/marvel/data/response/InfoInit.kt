package com.newteenho.marvel.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoInit(
    @Json(name = "attributionText")
    val attributionText: String,
    @Json(name = "data")
    val data: Data
)