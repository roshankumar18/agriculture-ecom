package com.example.agroic.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agroic.databinding.FragmentLoginBinding
import com.example.agroic.model.LoginRequestBody
import com.example.agroic.retrofit.RetrofitObject
import com.example.agroic.retrofit.Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import org.json.JSONObject


class LoginFragment : Fragment() {
    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater,container,false)
        fragmentLoginBinding.login.setOnClickListener {
            val service = RetrofitObject.getInstance().create(Service::class.java)
            GlobalScope.launch(Dispatchers.IO){
                val response = service.login(LoginRequestBody("roshan@email.com","password"))
                Log.d("test", "onCreateView: ${response}")
                Log.d("test", "onCreateView: ${response.body()}")

            }


        }


        return fragmentLoginBinding.root
    }



}