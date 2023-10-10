package com.example.agroic.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.agroic.model.seeds.SeedsProductItem
import com.example.agroic.network.api.ApiService
import retrofit2.Retrofit
import javax.inject.Inject

class ProductRepository @Inject constructor(private val retrofit: Retrofit) {

    private val _seeds = MutableLiveData<List<SeedsProductItem>>()

    val seeds : LiveData<List<SeedsProductItem>>
        get() = _seeds

    suspend fun getAllProduct() {
        val service = retrofit.create(ApiService::class.java)
        val response = service.getAllSeeds()
        if (response.isSuccessful){
            _seeds.postValue(response.body()!!.toMutableList())
        }else{
            //to be implemented
        }

    }
}