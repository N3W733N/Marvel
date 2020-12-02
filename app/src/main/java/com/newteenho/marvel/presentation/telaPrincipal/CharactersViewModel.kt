package com.newteenho.marvel.presentation.telaPrincipal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newteenho.marvel.data.network.ApiService
import com.newteenho.marvel.data.response.InfoInit
import com.newteenho.marvel.data.response.Results
import retrofit2.Call
import retrofit2.Response

class CharactersViewModel : ViewModel() {
    val charactersMutableLiveData = MutableLiveData<List<Results>>()
    val charactersLiveData: LiveData<List<Results>> = charactersMutableLiveData

    fun getCharacters() {
        ApiService.run {
            service.getCharacters().enqueue(object : retrofit2.Callback<InfoInit> {
                override fun onResponse(call: Call<InfoInit>, response: Response<InfoInit>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            charactersMutableLiveData.value = it.data.results
                        }
                    }
                }

                override fun onFailure(call: Call<InfoInit>, t: Throwable) {
                    Log.e("onFailure", t.message.toString())
                }
            })
        }
    }
}