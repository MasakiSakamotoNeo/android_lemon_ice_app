package com.example.lemoniceapp.ui.main.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.data.TimeLine
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineItem
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineOption
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineUI

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TimeLineSection(
    onClickTimeLineItem: (TimeLineItem) -> Unit = {}
) {
    Column {
        Text(
            text = stringResource(R.string.timeline),
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        TimeLineUI(
            items = mutableListOf<TimeLineItem>().apply {
                TimeLine.values().forEach { timeLine ->
                    add(
                        TimeLineItem(
                            key = timeLine.key,
                            title = timeLine.title,
                            time = timeLine.time,
                            imageResId = timeLine.bgImageResId
                        )
                    )
                }
            },
            header = { title ->
                Text(
                    text = title,
                    color = colorResource(R.color.lemon_ice_text_green),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .background(colorResource(id = R.color.lemon_ice_main_bg))
                        .padding(start = 8.dp)
                )
            },
            time = { timeStr ->
                // TODO:
                Row(
                    modifier = Modifier
                        .background(colorResource(R.color.lemon_ice_main_bg))
                        .padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.DateRange,
                        contentDescription = "time icon",
                        tint = colorResource(R.color.lemon_ice_text_green)
                    )
                    Text(
                        text = timeStr,
                        color = colorResource(R.color.lemon_ice_text_green),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            },
            content = { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.lemon_ice_main_bg))
                        .padding(top = 8.dp, end = 48.dp)
                ) {
                    Image(
                        painter = painterResource(item.imageResId),
                        contentDescription = "timeline info",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .clickable { onClickTimeLineItem(item) },
                    )
                }
            },
            timeLineOption = TimeLineOption(contentHeight = 88.dp),
            modifier = Modifier
                .background(colorResource(R.color.lemon_ice_main_bg))
                .padding(horizontal = 16.dp)
        )
    }
}
