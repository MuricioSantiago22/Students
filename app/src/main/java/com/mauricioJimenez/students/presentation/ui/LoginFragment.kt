package com.mauricioJimenez.students.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
    }


}