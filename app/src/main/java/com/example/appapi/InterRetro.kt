package com.example.appapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InterRetro {

    @GET("/ws/{cep}/son/")
    fun get(@Path("cep") cep: String): Call<CEPModel>

}