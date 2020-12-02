package com.newteenho.marvel.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Thumbnail(
    @Json(name = "path")
    val path: String,
    @Json(name = "id")
    val extension: String
)
