package com.example.kidlock.uilayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kidlock.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

    }
}
