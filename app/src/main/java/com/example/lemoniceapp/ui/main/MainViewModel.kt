package com.example.lemoniceapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    var navController: NavController? = null

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is OnClickDrawerMenu -> {
                viewModelScope.launch {
                    // TODO:
                }
            }
            is OnClickItem -> {
                // TODO:
            }
            is OnClickHistoryItem -> {
                navController?.navigate(HistoryScreenSpec.route)
            }
            is OnClickWorkItem -> {
                navController?.navigate(WorkScreenSpec.route)
            }
            is OnClickTimeLineItem -> {
                navController?.navigate(TimeLineScreenSpec.route)
            }
        }
    }
}
