package com.example.agroic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agroic.model.seeds.SeedsProductItem
import com.example.agroic.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository):ViewModel() {

    fun getAllSeeds(){
        viewModelScope.launch{
            repository.getAllProduct()
        }
    }
    val seeds : LiveData<List<SeedsProductItem>>
        get() = repository.seeds


}