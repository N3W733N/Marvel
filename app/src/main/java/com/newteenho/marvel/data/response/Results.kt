package com.newteenho.marvel.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results(
    @Json(name = "id")
    val id:Int,
    @Json(name = "name")
    val name:String,
    @Json(name = "description")
    val description:String,
    @Json(name = "thumbnail")
    val thumbnail:Thumbnail,
)