package com.example.kidlock.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColor(
    val Jade: Color = Color(0XFF00BD6E),
    val DarkViolet: Color = Color(0XFF8C00CE),
    val LightningYellow: Color = Color(0XFFFA9620),
    val  DodgerBlue: Color = Color(0XFF2092FA),
    val OrangeRed: Color = Color(0XFFFF3E13),
    val Jacarta: Color = Color(0XFF3C315A),
    val SealBrown: Color = Color(0x40000000),
    val white: Color = Color(0xFFFFFFFF),
    val red: Color = Color(0xFFFF3E13),
    val JadeBackGround: Color = Color(0xFFFD6FFEE),
    val LightningYellowBackGround: Color = Color(0xFFFFEF5EA),
    val OrangeRedBackGround: Color = Color(0xFFFFFE2DC)
)
val AppColorLoaction = compositionLocalOf { AppColor() }