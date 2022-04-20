package com.example.methodapi.model


import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("data")
    val commonData: Data,
    @SerializedName("success")
    val success: Boolean
)