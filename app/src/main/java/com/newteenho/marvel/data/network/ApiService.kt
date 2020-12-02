package com.newteenho.marvel.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object ApiService {
    private fun initRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val service: Endpoint = initRetrofit().create(Endpoint::class.java)
}