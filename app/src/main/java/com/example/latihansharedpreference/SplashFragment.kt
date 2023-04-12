package com.example.latihansharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.latihansharedpreference.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding
    lateinit var sharedSplash: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater)
        Handler(Looper.myLooper()!!).postDelayed({

            sharedSplash =
                requireContext().getSharedPreferences("dataregistrasi", Context.MODE_PRIVATE)
            if (sharedSplash.getString("nama", "").equals("")) {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment5)
            } else if (sharedSplash.getString("nama", "")!!.isNotEmpty()) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }, 3000)
        return binding.root
    }


}