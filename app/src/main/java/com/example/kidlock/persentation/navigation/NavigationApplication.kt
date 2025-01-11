package com.example.kidlock.persentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.kidlock.persentation.views.dashboard.DashboardFragment
import com.example.kidlock.persentation.views.forgotpassword.ForgotPassFragment
import com.example.kidlock.persentation.views.kiddevice.KidDeviceFragment
import com.example.kidlock.persentation.views.loginfragment.LoginFragment
import com.example.kidlock.persentation.views.mainscreen.MainScreen
import com.example.kidlock.persentation.views.setting.SettingsFragment
import com.example.kidlock.persentation.views.signup.SignUpFragment
import com.example.kidlock.persentation.views.wellcomefragment.WellComeFragment

class NavigationApplication constructor(val navController: NavController) : MainScreen() {


    fun navigationApplication(): NavController {
        navController.graph = navController.createGraph(
            startDestination = ApplicationPages.WELL_COME_FRAGMENT
        ) {
            // Associate each destination with one of the route constants.
            fragment<WellComeFragment>(ApplicationPages.WELL_COME_FRAGMENT) {
            }
            fragment<LoginFragment>(ApplicationPages.LOGIN_ACCOUNT_FRAGMENT) {
            }
            fragment<DashboardFragment>(ApplicationPages.DASHBOARD) {

            }
            fragment<SignUpFragment>(ApplicationPages.SIGNUP) {

            }
            fragment<ForgotPassFragment>(ApplicationPages.FORGOT_PASSWORD) {

            }
            fragment<SettingsFragment>(ApplicationPages.SETTING_PARENT) {

            }
            fragment<KidDeviceFragment>(ApplicationPages.KID_DEVICE)
        }
        return navController
    }


}

fun popStack(
    navController1: NavController,
    route1: String,
    saveState: Boolean,
    inclusiveCheck: Boolean,
    launchSingleTopCheck: Boolean = false
) {

    navController1.popBackStack(
        route1,
        inclusiveCheck,
        saveState,
    )
//    navController1.navigate(route) {
//        popUpTo(route.toString()) {
//            inclusiveCheck
//            saveState
//        }
//        launchSingleTop = launchSingleTopCheck
//        restoreState = true
//    }
}