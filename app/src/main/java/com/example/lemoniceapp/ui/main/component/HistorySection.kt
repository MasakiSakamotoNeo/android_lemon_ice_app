package com.example.lemoniceapp.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.data.History

@Composable
fun HistorySection(
    onClickItem: (History) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(R.string.history),
            color = colorResource(R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "（${stringResource(R.string.past_events)}）",
            color = colorResource(id = R.color.lemon_ice_text_green),
            fontSize = 14.sp,
        )
    }

    LazyRow {
        items(History.values().size) { index ->
            CardItem(index) { onClickItem(it) }
        }
    }
}

@Composable
private fun CardItem(
    index: Int,
    onClickItem: (History) -> Unit = {}
) {
    val history = History.values()[index]

    var lastItemPaddingEnd = if (index == History.values().size - 1) 16.dp else 0.dp
    var image = painterResource(history.imageResId)

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Image(
            painter = image,
            contentDescription = "history card",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clip(RoundedCornerShape(24.dp))
                .clickable { onClickItem(history) },
        )
    }
}

@Preview
@Composable
private fun HistorySectionPreview() {
    HistorySection()
}
