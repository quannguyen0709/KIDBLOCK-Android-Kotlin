package com.example.kidlock.uilayer.state

import android.graphics.drawable.Icon
import com.example.kidlock.R

data class BadApp(
    val list: List<App> = listOf(App(R.drawable._03_twitter_1, "Facebook", "10:00 AM"),
        App(R.drawable._03_twitter_1__2_, " Tiktok", "10:10 AM"),
        App(R.drawable._03_twitter_1__1_, "Twitter", "10:15 AM"),
        App(R.drawable._03_twitter_1__3_, "Youtube", "10:30 AM"))
)
data class App(
    val icon: Int,
    val nameApp: String,
    val timeApp: String,
    
)
