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

val worksList = listOf(
    Triple("ナレっぽ", "山田 太郎", R.mipmap.ic_work_nareppo),
    Triple("Junaブログ", "山田 太郎", R.mipmap.ic_work_junablog),
    Triple("ともだちカメラ", "山田 太郎", R.mipmap.ic_work_tomodachicamera),
    Triple("ポジカジ", "山田 太郎", R.mipmap.ic_work_pojikaji),
)
@Composable
fun WorksSection(
    onClickWorkItem: (Triple<String, String, Int>) -> Unit
) {
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
                WorkItem(index) { onClickWorkItem(it) }
            }
        }
    }
}

@Composable
private fun WorkItem(
    index: Int,
    onClickWorkItem: (Triple<String, String, Int>) -> Unit = {}
) {
    val workItem = worksList[index]
    val lastPaddingEnd = if (index == worksList.size - 1) 16.dp else 0.dp
    val image = painterResource(workItem.third)

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
            text = workItem.first,
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}
