package com.example.methodapi.model


import com.google.gson.annotations.SerializedName

data class Update(
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("photo")
    val photo: String?,
)