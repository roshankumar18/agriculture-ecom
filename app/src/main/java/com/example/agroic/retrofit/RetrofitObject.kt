package com.example.agroic.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {


    fun getInstance() : Retrofit{

        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Add your interceptor
            // Add any other OkHttp configurations you need
            .build()
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
    }
}