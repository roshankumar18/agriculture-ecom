package com.example.agroic.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("_id")
    val id: String,
    val email: String,
    val isAdmin: Boolean,
    val name: String,
    val token: String
)