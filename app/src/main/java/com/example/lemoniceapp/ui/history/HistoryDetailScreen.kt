package com.example.lemoniceapp.ui.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.data.getHistoryByKey

@Composable
fun HistoryDetailScreen(
    key: String,
    viewModel: HistoryViewModel
) {
    HistoryDetailUI(
        key,
        onEvent = { viewModel.onEvent(it) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HistoryDetailUI(
    key: String,
    onEvent: (HistoryDetailScreenEvent) -> Unit
) {
    val historyItem = getHistoryByKey(key)
    Scaffold(
        topBar = {
            Surface(shadowElevation = 4.dp) {
                CenterAlignedTopAppBar(
                    title = {
                        Box {
                            Text(
                                text = historyItem.title,
                                fontSize = 18.sp,
                                color = colorResource(R.color.lemon_ice_white)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = colorResource(R.color.lemon_ice_green)
                    ),
                    navigationIcon = {
                        IconButton(
                            onClick = { onEvent(OnBackPress) }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = colorResource(R.color.lemon_ice_white)
                            )
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(colorResource(R.color.lemon_ice_main_bg))
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(historyItem.imageResId),
                        contentDescription = "history image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Row(modifier = Modifier.padding(bottom = 8.dp)) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Description",
                            tint = colorResource(R.color.lemon_ice_text_green)
                        )
                        Text(
                            text = "Description",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.lemon_ice_text_green),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Text(text = "")

                    Row(modifier = Modifier.padding(bottom = 8.dp)) {
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = "Author",
                            tint = colorResource(R.color.lemon_ice_text_green)
                        )
                        Text(
                            text = "Author",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.lemon_ice_text_green),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Text(text = "")
                }
            }
        }
    }
}
