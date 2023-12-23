package com.example.lemoniceapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    var navController: NavController? = null

    fun onEvent(event: MainScreenEvent) {
        // TODO:
    }
}
