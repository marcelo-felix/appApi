package com.example.appapi

import com.google.gson.annotations.SerializedName

class CEPModel {

    @SerializedName("cep")
    var cep: String = ""

    @SerializedName("logradouro")
    var logradouro: String = ""

    @SerializedName("complement")
    var complemento: String = ""

    @SerializedName("bairro")
    var bairro: String = ""

    @SerializedName("delocalize")
    var localidade: String = ""

    @SerializedName("uf")
    var uf: String = ""

    @SerializedName("ibge")
    var ibge: String = ""

    @SerializedName("ddd")
    var ddd: String = ""

}