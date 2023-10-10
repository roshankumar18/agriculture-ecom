package com.example.agroic.network.api

import com.example.agroic.model.LoginRequestBody
import com.example.agroic.model.LoginResponse
import com.example.agroic.model.seeds.SeedsProduct
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{

    @POST("/api/users/login")
//    suspend fun login(@Body body: LoginRequestBody):Response<String>
    suspend fun login(@Body body: LoginRequestBody) :Response<LoginResponse>

    @GET("/api/seeds")
    suspend fun getAllSeeds():Response<SeedsProduct>
}