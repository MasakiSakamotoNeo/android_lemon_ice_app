package com.example.lemoniceapp.ui.work

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor() : ViewModel() {

    var navController: NavController? = null

    fun onEvent(event: WorkDetailScreenEvent) {
        when (event) {
            is OnBackPress -> {
                navController?.navigateUp()
            }
        }
    }
}
