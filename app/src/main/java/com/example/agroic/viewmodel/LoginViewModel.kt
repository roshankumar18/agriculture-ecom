package com.example.agroic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agroic.model.LoginRequestBody
import com.example.agroic.model.LoginResponse
import com.example.agroic.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository): ViewModel() {

    fun login(body: LoginRequestBody){
        viewModelScope.launch{
            repository.login(body)
        }
    }
    val loginResponse : LiveData<LoginResponse>
        get() = repository.loginResponse


}