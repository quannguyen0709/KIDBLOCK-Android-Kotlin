package com.example.kidlock.persentation.views.statekeyboard

import android.graphics.Rect
import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type

enum class Keyboard {
    Opened, Closed
}

@Composable
fun keyboardAsStateWithoutApi(): State<Keyboard> {
    val keyboardState = remember { mutableStateOf(Keyboard.Closed) }
    val view = LocalView.current
    DisposableEffect(view) {
        val onGlobalListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.rootView.height
            val keypadHeight = screenHeight - rect.bottom
            keyboardState.value = if (keypadHeight > screenHeight * 0.15) {
                Keyboard.Opened
            } else {
                Keyboard.Closed
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalListener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalListener)
        }
    }

    return keyboardState
}

@Composable
fun keyboardAsStateWithApi(): State<Keyboard> {
    val keyboardState = remember { mutableStateOf(Keyboard.Closed) }
    val view = LocalView.current
    DisposableEffect(LocalWindowInfo.current) {
        val listener = ViewTreeObserver.OnPreDrawListener{
            keyboardState.value = if(ViewCompat.getRootWindowInsets(view)?.isVisible(WindowInsetsCompat.Type.ime()) == true){Keyboard.Opened}else{Keyboard.Closed}
            true
        }
        view.viewTreeObserver.addOnPreDrawListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnPreDrawListener(listener)
        }
    }

    return keyboardState
}

@Composable
fun keyboardAsStateWithApiTest(): State<Keyboard> {
    val keyboardState = remember { mutableStateOf(Keyboard.Closed) }
    val view = LocalView.current
    val insets = ViewCompat.getRootWindowInsets(view);
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
        keyboardState.value = if (insets!!.isVisible(WindowInsetsCompat.Type.ime())){Keyboard.Opened}else{Keyboard.Closed}
        insets
    }

    return keyboardState
}