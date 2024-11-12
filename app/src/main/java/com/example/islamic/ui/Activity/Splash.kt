package com.example.islamic.ui.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.islamic.MainActivity
import com.example.islamic.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
Handler(Looper.getMainLooper())
    .postDelayed({ starthomeActivity() },3000)

   }

    private fun starthomeActivity() {

        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}