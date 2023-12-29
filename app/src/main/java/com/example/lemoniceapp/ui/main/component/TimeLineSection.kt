package com.example.lemoniceapp.ui.main.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.ui.main.component.timeline.TimeLine
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineItem
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineOption

data class Item(override val key: Int) : TimeLineItem<Int>
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TimeLineSection() {
    Column {
        Text(
            text = "TimeLine",
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        TimeLine(
            items = listOf(
                Item(1),
                Item(2),
                Item(3),
                Item(4),
                Item(5),
            ),
            header = { key ->
                Text(
                    text = "Make it Easy $key.",
                    modifier = Modifier.background(colorResource(R.color.lemon_ice_white))
                )
            },
            content = { item ->
                Text(
                    text = "Welcome ${item.key}",
                    modifier = Modifier.background(colorResource(R.color.lemon_ice_white))
                )
            },
            timeLineOption = TimeLineOption(contentHeight = 50.dp),
            modifier = Modifier.background(colorResource(R.color.lemon_ice_white))
        )
    }
}
