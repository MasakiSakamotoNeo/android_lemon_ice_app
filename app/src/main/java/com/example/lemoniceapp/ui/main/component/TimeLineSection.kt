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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.ui.main.component.timeline.TimeLine
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineItem
import com.example.lemoniceapp.ui.main.component.timeline.TimeLineOption

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TimeLineSection(
    onClickTimeLineItem: (TimeLineItem) -> Unit = {}
) {
    Column {
        Text(
            text = "TimeLine",
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        TimeLine(
            items = listOf(
                TimeLineItem(
                    title = "Opening",
                    time = "13:00〜13:10",
                    imageResId = R.drawable.opening_header
                ),
                TimeLineItem(
                    title = "ExtensionLab",
                    time = "13:20〜13:50",
                    imageResId = R.drawable.extensionlab_team_header
                ),
                TimeLineItem(
                    title = "ハッカソン発表会",
                    time = "14:00〜14:40",
                    imageResId = R.drawable.hackathon_header
                ),
                TimeLineItem(
                    title = "アプリ部活動報告",
                    time = "14:50〜15:20",
                    imageResId = R.drawable.itpm_application_section_header
                ),
                TimeLineItem(
                    title = "0から1へインフラの世界",
                    time = "15:30〜16:00",
                    imageResId = R.drawable.hirata_header
                ),
                TimeLineItem(
                    title = "3Dメジャー機能実装で難しかったところ",
                    time = "16:10〜16:40",
                    imageResId = R.drawable.sakamoto_header
                ),
                TimeLineItem(
                    title = "Closing",
                    time = "16:50〜17:00",
                    imageResId = R.mipmap.melon_ice
                )
            ),
            header = { title ->
                Text(
                    text = title,
                    color = colorResource(R.color.lemon_ice_text_green),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .background(colorResource(R.color.lemon_ice_white))
                        .padding(start = 8.dp)
                )
            },
            time = { timeStr ->
                // TODO:
                Row(
                    modifier = Modifier
                        .background(colorResource(R.color.lemon_ice_white))
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
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            },
            content = { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.lemon_ice_white))
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
                .background(colorResource(R.color.lemon_ice_white))
                .padding(horizontal = 16.dp)
        )
    }
}
