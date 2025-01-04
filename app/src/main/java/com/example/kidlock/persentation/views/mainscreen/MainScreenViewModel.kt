package com.example.kidlock.persentation.views.mainscreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.kidlock.persentation.navigation.NavigationApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {
    lateinit var navControllerApplication: NavController

    fun controllerNavApplication(controller: NavController){
        navControllerApplication = NavigationApplication(navController = controller).navigationApplication()
    }
}