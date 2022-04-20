package com.example.methodapi.model


import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("data")
    val dataLogin: Login,
    @SerializedName("success")
    val success: Boolean
)