package com.newteenho.marvel.presentation.telaDetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newteenho.marvel.data.network.ApiService
import com.newteenho.marvel.data.response.InfoInit
import com.newteenho.marvel.data.response.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel : ViewModel() {
    val heroesLiveData = MutableLiveData<Results>()

    fun getCharById(id: String) {

        ApiService.service.getCharactersByID(id.toInt()).enqueue(object : Callback<InfoInit> {

            override fun onResponse(call: Call<InfoInit>, response: Response<InfoInit>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        heroesLiveData.value = it.data.results.first()
                    }
                }
            }

            override fun onFailure(call: Call<InfoInit>, t: Throwable) {
                Log.e("ERRO NA API", t.message.toString())
            }
        })
    }
}