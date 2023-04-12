package com.example.latihansharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.latihansharedpreference.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var dataPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataPref= requireContext().getSharedPreferences("dataregistrasi", Context.MODE_PRIVATE)
        binding.tvHello.text = "Hello,  " + dataPref.getString("nama", "name")

        binding.btnLogout.setOnClickListener {
            val dataPref = dataPref.edit()
            dataPref.clear()
            dataPref.apply()
            Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_loginFragment5)
        }
    }
}