package com.example.agroic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.agroic.R
import com.example.agroic.adapter.BannerAdapter
import com.example.agroic.adapter.ProductAdapter
import com.example.agroic.databinding.FragmentHomeBinding
import com.example.agroic.model.seeds.SeedsProduct
import com.example.agroic.network.api.ApiService
import com.example.agroic.repository.ProductRepository
import com.example.agroic.viewmodel.ProductViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    @Inject lateinit var repository: ProductRepository
    @Inject lateinit var retrofit: Retrofit
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val images = listOf("https://plus.unsplash.com/premium_photo-1664304967446-d1f2f8201422?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8dXJsfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60","https://images.unsplash.com/photo-1598128558393-70ff21433be0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8dXJsfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        val bannerAdapter = BannerAdapter(images)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navView?.visibility = View.VISIBLE


        binding.bannerRecyclerView.adapter = bannerAdapter
        val service = retrofit.create(ApiService::class.java)
        var response: Response<SeedsProduct>? = null

        val productViewModel = ViewModelProvider(requireActivity()).get(ProductViewModel::class.java)
        productViewModel.getAllSeeds()
        productViewModel.seeds.observe(viewLifecycleOwner, Observer {
            productAdapter = ProductAdapter(it)
            binding.MachineRecyclerView.adapter = productAdapter
            binding.seedRecyclerView.adapter = productAdapter
            binding.popularRecyclerView.adapter = productAdapter
        })


        return binding.root
    }


}