package com.example.agroic.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.agroic.model.LoginRequestBody
import com.example.agroic.model.LoginResponse
import com.example.agroic.network.api.ApiService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val service: ApiService){

    private val _loginResponse = MutableLiveData<LoginResponse>()

    val loginResponse : LiveData<LoginResponse>
        get() = _loginResponse

    suspend fun login(body: LoginRequestBody) {
        val response =  service.login(body)
        if(response.code()!=401){
            _loginResponse.postValue(response.body())
        }else{
            // to be implemented
        }

    }

}