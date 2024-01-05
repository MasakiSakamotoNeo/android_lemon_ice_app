package com.example.lemoniceapp.ui.main

import com.example.lemoniceapp.data.History
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineItem

sealed interface MainScreenEvent

object OnClickItem : MainScreenEvent

object OnClickDrawerMenu : MainScreenEvent

data class OnClickHistoryItem(
    val history: History
) : MainScreenEvent

data class OnClickWorkItem(
    val triple: Triple<String, String, Int>
) : MainScreenEvent

data class OnClickTimeLineItem(
    val item: TimeLineItem
) : MainScreenEvent
