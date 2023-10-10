package com.example.agroic.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.agroic.R
import com.example.agroic.databinding.FragmentLoginBinding
import com.example.agroic.model.LoginRequestBody
import com.example.agroic.model.LoginResponse
import com.example.agroic.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.math.log

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var fragmentLoginBinding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private  var loginResponse: LoginResponse? =null
    private  var sharedPreferences: SharedPreferences? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater,container,false)

        isUserLoggedIn()


        loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
        fragmentLoginBinding.login.setOnClickListener {
            val email = fragmentLoginBinding.emailText.text
            val password = fragmentLoginBinding.passwordText.text
            login(email.toString(),password.toString())
        }
        fragmentLoginBinding.signin.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signInFragment)
        }
//        sharedPreferences = activity?.getSharedPreferences("login",Context.MODE_PRIVATE)
        sharedPreferences = context?.getSharedPreferences("login",Context.MODE_PRIVATE)
        return fragmentLoginBinding.root
    }

    private fun isUserLoggedIn() {
        val pref = context?.getSharedPreferences("login",Context.MODE_PRIVATE)
        val token = pref?.getString("token","")
        if(token!=""){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    private fun login(email: String, password: String) {
//        if(email.isNotEmpty() && password.isNotEmpty()) {
            loginViewModel.login(LoginRequestBody("roshan@email.com","password"))
            loginViewModel.loginResponse.observe(viewLifecycleOwner, Observer {
               loginResponse = it
                if (loginResponse!=null) {

                    val editor = sharedPreferences?.edit()
                    editor?.putString("token",loginResponse?.token)
                    editor?.apply()

                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                }else{
                    //to be implemented
                }
           })


//        }
    }


}