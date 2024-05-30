package com.example.appapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InterRetro {

    @GET("/ws/{cep}/json/")
    fun get(@Path("cep") cep: String): Call<CEPModel>

}