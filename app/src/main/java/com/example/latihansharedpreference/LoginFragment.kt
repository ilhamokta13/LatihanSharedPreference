package com.example.latihansharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.latihansharedpreference.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var dataPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataPref = requireContext().getSharedPreferences("dataregistrasi", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener{
            var getUsername = dataPref.getString("username", "")
            var getPassword = dataPref.getString("password", "")

            var username = binding.logUsername.text.toString()
            var password = binding.logPassword.text.toString()

            if (username == getUsername && password.equals(getPassword)){
                Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_homeFragment2)

            }else{
                Toast.makeText(context, "Username atau password anda salah !", Toast.LENGTH_SHORT).show()
            }

        }

        binding.textReg.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}