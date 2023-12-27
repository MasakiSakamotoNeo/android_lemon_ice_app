package com.example.lemoniceapp.ui.main

sealed interface MainScreenEvent

object OnClickItem : MainScreenEvent

object OnClickDrawerMenu : MainScreenEvent
