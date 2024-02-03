package com.example.lemoniceapp.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.lemoniceapp.data.Work

@Composable
fun WorksSection(
    onClickWorkItem: (Work) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(R.string.works),
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "（${stringResource(R.string.works_so_far)}）",
            color = colorResource(id = R.color.lemon_ice_text_green),
            fontSize = 14.sp,
        )
    }

    Column {

        LazyRow {
            items(Work.values().size) { index ->
                WorkItem(index) { onClickWorkItem(it) }
            }
        }
    }
}

@Composable
private fun WorkItem(
    index: Int,
    onClickWorkItem: (Work) -> Unit = {}
) {
    val workItem = Work.values()[index]
    val lastPaddingEnd = if (index == Work.values().size - 1) 16.dp else 0.dp
    val image = painterResource(workItem.thumbnailImageResId)

    Box(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = lastPaddingEnd)
            .clip(RoundedCornerShape(24.dp))
            .size(120.dp)
            .clickable { onClickWorkItem(workItem) },
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = image,
            contentDescription = "work image",
            contentScale = ContentScale.Crop
        )
        Text(
            text = workItem.title,
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}
