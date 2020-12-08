package com.newteenho.marvel.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiService {

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service: Endpoint = initRetrofit().create(Endpoint::class.java)
}