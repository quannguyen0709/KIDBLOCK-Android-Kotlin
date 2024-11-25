package com.example.kidlock.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun KidlockTheme(
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(AppColorLoaction provides AppColor()) {
        MaterialTheme(
            typography = Typography,
            content = content,
        )
    }

}

object KidlockTheme {
    val MaterialTheme.color: AppColor
        @Composable
        get() = AppColorLoaction.current
}