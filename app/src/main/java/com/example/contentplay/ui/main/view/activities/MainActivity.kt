package com.example.contentplay.ui.main.view.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contentplay.R
import com.example.contentplay.ui.main.view.fragments.ContentPlayMainFragment
import com.example.contentplay.utils.LiveNetworkChecker

class MainActivity: AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LiveNetworkChecker.init(application)
        val contentPlayMainFragment = ContentPlayMainFragment()
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(android.R.id.content, contentPlayMainFragment).commitNow()
        }
    }

    override fun onBackPressed() {
        // Back press operations and double press back to exit functionality
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press back again to exit from app.", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed(
            { doubleBackToExitPressedOnce = false },
            2000
        )
    }

}