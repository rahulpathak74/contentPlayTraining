package com.example.contentplay.ui.main.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contentplay.R
import com.example.contentplay.ui.main.view.fragments.ContentPlayMainFragment

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contentPlayMainFragment = ContentPlayMainFragment()
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(android.R.id.content, contentPlayMainFragment).commitNow()
        }
    }

}