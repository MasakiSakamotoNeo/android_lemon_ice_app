package com.example.lemoniceapp.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

@Composable
fun VenueSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(id = R.string.venue),
            color = colorResource(id = R.color.lemon_ice_text_green),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "（${stringResource(R.string.venue_image)}）",
            color = colorResource(id = R.color.lemon_ice_text_green),
            fontSize = 14.sp,
        )
    }

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = "map",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .fillMaxWidth()
        )
    }
}
