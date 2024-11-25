package com.example.kidlock.persentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object SizeScreen {
    @Composable
    fun heightSize(fraction: Float = 1f): Dp{
        return (LocalConfiguration.current.screenHeightDp.toFloat() * fraction).dp
    }
    @Composable
    fun widthSize(fraction: Float = 1f): Dp{
        return (LocalConfiguration.current.screenWidthDp.toFloat() * fraction).dp
    }
}