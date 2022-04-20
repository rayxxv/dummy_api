package com.example.methodapi.service

import com.example.methodapi.model.*
import com.musnadil.day6ch5.model.RequestLogin
import com.musnadil.day6ch5.model.RequestRegister
import io.reactivex.rxjava3.core.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("auth/register")
    fun register(@Body requestBody: RequestRegister): Call<DataResponse>

    @POST("auth/login")
    fun login(@Body requestBody: RequestLogin): Call<LoginResponse>

    @GET("auth/me")
    fun auth(@Header("Authorization") token: String): Call<DataResponse>

    @Multipart
    @PUT("users")
    fun update(
        @Header("Authorization") token: String,
        @Part("username") username: RequestBody,
        @Part("email") email: RequestBody,
    ): Call<UpdateResponse>

}