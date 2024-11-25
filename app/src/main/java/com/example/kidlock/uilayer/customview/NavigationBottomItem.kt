package com.example.kidlock.uilayer.customview

import com.example.kidlock.R

sealed class NavigationBottomItem (var route: String, var icon: Int, var title: String){
    object Home: NavigationBottomItem("home", R.drawable.home, "Home")
    object Mode: NavigationBottomItem("mode", R.drawable.usercheck,"Mode")
    object BlockSetting: NavigationBottomItem("blocksetting", R.drawable.shield, "Block settings")
}
