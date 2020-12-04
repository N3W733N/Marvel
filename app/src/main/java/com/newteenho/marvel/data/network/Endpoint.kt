package com.newteenho.marvel.data.network

import com.newteenho.marvel.data.response.InfoInit
import com.newteenho.marvel.util.HASH
import com.newteenho.marvel.util.PUBLIC_KEY
import com.newteenho.marvel.util.TS
import com.newteenho.marvel.util.md5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Endpoint {
    @GET("characters")
    fun getCharacters(
        @Query("limit") limit: Int = 100,
        @Query("ts") ts: String = TS,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()
    ): Call<InfoInit>
}