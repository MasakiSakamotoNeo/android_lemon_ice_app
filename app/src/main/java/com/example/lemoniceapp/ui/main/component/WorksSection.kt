package com.example.lemoniceapp.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R

val worksList = listOf(
    Triple("TODOリスト", "山田 太郎", R.mipmap.ic_launcher),
    Triple("TODOリスト", "山田 太郎", R.mipmap.ic_launcher),
    Triple("TODOリスト", "山田 太郎", R.mipmap.ic_launcher),
)
@Composable
fun WorksSection() {
    Column {
        Text(
            text = "Works",
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(worksList.size) { index ->
                WorkItem(index)
            }
        }
    }
}

@Composable
private fun WorkItem(
    index: Int
) {
    val workItem = worksList[index]
    var lastPaddingEnd = if (index == worksList.size - 1) 16.dp else 0.dp

    Box(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = lastPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(colorResource(R.color.lemon_ice_work_item_bg))
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorResource(R.color.lemon_ice_work_item_bg))
                    .padding(6.dp)
            ) {
                Image(
                    painter = painterResource(R.mipmap.melon_ice),
                    contentDescription = null
                )
            }

            Text(
                text = workItem.first,
                color = colorResource(R.color.lemon_ice_text_green),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}
