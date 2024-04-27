package com.mauricioJimenez.students.presentation.ui.auth

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.mauricioJimenez.students.databinding.ActivityAuthBinding
import com.mauricioJimenez.students.presentation.ui.base.BaseActivity


class AuthActivity : BaseActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)
    }
}