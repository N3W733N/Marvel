package com.newteenho.marvel.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data (
    @Json(name = "offset")
    val offset:Int,
    @Json(name = "limit")
    val limit:Int,
    @Json(name = "results")
    val results:List<Results>,

)
