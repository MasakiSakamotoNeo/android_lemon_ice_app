package com.example.lemoniceapp.ui.history

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(): ViewModel() {

    var navController: NavController? = null

    fun onEvent(event: HistoryDetailScreenEvent) {
        when (event) {
            is OnBackPress -> {
                navController?.navigateUp()
            }
        }
    }
}