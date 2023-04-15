package com.abdosharaf.gdgfinder.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.abdosharaf.gdgfinder.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, MainActivity::class.java).also { intent ->
                startActivity(intent)
                finishAffinity()
            }
        }, 1500L)
    }
}