package com.mauricioJimenez.students.presentation.ui.base

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
     fun navigate(activity: AppCompatActivity){
         val intent = Intent(this, activity::class.java)
         startActivity(intent)
         finish()
    }
}