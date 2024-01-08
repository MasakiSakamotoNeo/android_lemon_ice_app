package com.example.lemoniceapp.ui.main

import androidx.compose.material3.DrawerState
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    var navController: NavController? = null
    var drawerState: DrawerState? = null

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is OnClickItem -> {
                // TODO:
            }
            is OnClickHistoryItem -> {
                navController?.navigate("history_screen/${event.history.key}")
            }
            is OnClickWorkItem -> {
                navController?.navigate("work_screen/${event.work.key}")
            }
            is OnClickTimeLineItem -> {
                navController?.navigate("timeline_screen/${event.item.key}")
            }
            else -> {}
        }
    }
}
