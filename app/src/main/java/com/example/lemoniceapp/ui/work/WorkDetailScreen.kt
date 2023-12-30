package com.example.lemoniceapp.ui.work

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WorkDetailScreen() {
    WorkDetailUI()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WorkDetailUI() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box() {
                        Text(text = "Work")
                    }
                }
            )
        }
    ) { paddingValues ->
        Text(
            text = "サンプル",
            modifier = Modifier.padding(paddingValues)
        )
    }
}
