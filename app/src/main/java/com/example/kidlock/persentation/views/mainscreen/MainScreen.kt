package com.example.kidlock.persentation.views.mainscreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kidlock.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainScreen : AppCompatActivity() {
    private val mainScreenViewModel by viewModels<MainScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_screen)
        mainScreenViewModel.controllerNavApplication((supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController)
    }

    override fun onStart() {
        super.onStart()
    }
}
