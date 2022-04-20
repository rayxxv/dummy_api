package com.example.methodapi.model


import com.google.gson.annotations.SerializedName

data class UpdateResponse(
    @SerializedName("data")
    val updateData: Update,
    @SerializedName("success")
    val success: Boolean
)