package com.example.lemoniceapp.util

import android.view.View
import android.view.Window

fun hideSystemUI(window: Window) {
    val uiOptions = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    window.decorView.systemUiVisibility = uiOptions
}

fun showSystemUI(window: Window) {
    val uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
    window.decorView.systemUiVisibility = uiOptions
}