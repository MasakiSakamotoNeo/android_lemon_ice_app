package com.example.lemoniceapp.ui.work

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.data.getWorkByKey

@Composable
fun WorkDetailScreen(key: String) {
    WorkDetailUI(key)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WorkDetailUI(
    key: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box {
                        Text(
                            text = getWorkByKey(key).title,
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
                        onClick = {
                            // TODO:
                        }
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
            // TODO:
        }
    }
}
