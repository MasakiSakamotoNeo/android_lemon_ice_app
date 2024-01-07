package com.example.lemoniceapp.ui.timeline

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimeLineViewModel @Inject constructor(): ViewModel() {

    var navController: NavController? = null

    fun onEvent(event: TimeLineDetailScreenEvent) {
        when (event) {
            is OnBackPress -> {
                navController?.navigateUp()
            }
        }
    }
}
