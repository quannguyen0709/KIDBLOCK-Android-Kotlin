package com.example.kidlock.persentation.navigation

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.kidlock.persentation.views.dashboard.DashboardFragment
import com.example.kidlock.persentation.views.loginfragment.LoginFragment
import com.example.kidlock.persentation.views.mainscreen.MainScreen
import com.example.kidlock.persentation.views.signup.SignUpFragment
import com.example.kidlock.persentation.views.wellcomefragment.WellComeFragment

class NavigationApplication  constructor(val navController: NavController) : MainScreen() {


    fun navigationApplication( ): NavController{
        navController.graph = navController.createGraph(
            startDestination = ApplicationPages.WELL_COME_FRAGMENT
        ) {
            // Associate each destination with one of the route constants.
            fragment<WellComeFragment>(ApplicationPages.WELL_COME_FRAGMENT) {
            }
            fragment<LoginFragment>(ApplicationPages.LOGIN_ACCOUNT_FRAGMENT) {
            }
            fragment<DashboardFragment>(ApplicationPages.DASHBOARD){

            }
            fragment<SignUpFragment>(ApplicationPages.SIGNUP){

            }
        }
        return navController
    }
}