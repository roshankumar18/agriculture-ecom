package com.example.agroic.retrofit

import com.example.agroic.model.LoginRequestBody
import com.example.agroic.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Service{

    @POST("/api/users/login")
//    suspend fun login(@Body body: LoginRequestBody):Response<String>
    suspend fun login(@Body body: LoginRequestBody) :Response<LoginResponse>
}