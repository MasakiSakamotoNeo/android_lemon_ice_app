package com.example.lemoniceapp.ui.main

sealed interface MainScreenEvent

object OnClickItem : MainScreenEvent

object OnClickDrawerMenu : MainScreenEvent

data class OnClickHistoryItem(
    val pair: Pair<String, Int>
) : MainScreenEvent

data class OnClickWorkItem(
    val triple: Triple<String, String, Int>
) : MainScreenEvent
