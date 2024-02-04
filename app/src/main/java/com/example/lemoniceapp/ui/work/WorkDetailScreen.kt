package com.example.lemoniceapp.ui.work

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.data.getWorkByKey

@Composable
fun WorkDetailScreen(
    key: String,
    viewModel: WorkViewModel
) {
    WorkDetailUI(
        key,
        onEvent = { viewModel.onEvent(it) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WorkDetailUI(
    key: String,
    onEvent: (WorkDetailScreenEvent) -> Unit
) {
    val workItem = getWorkByKey(key)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box {
                        Text(
                            text = workItem.title,
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
                        painter = painterResource(workItem.bgImageResId),
                        contentDescription = "work image",
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

                    Text(
                        text = workItem.destination,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Row(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
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

                    Text(
                        text = workItem.author,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = colorResource(id = R.color.lemon_ice_text_green),
                            contentColor = colorResource(id = R.color.lemon_ice_white)
                        ),
                        onClick = {
                            // TODO: 「いいね」ボタンを押した時の処理の実装
                        }) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "like button icon",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text(text = stringResource(R.string.good))
                    }
                }
            }
        }
    }
}
