package com.example.lemoniceapp.ui.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HistoryScreen() {
    HistoryUI()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HistoryUI() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box() { Text(text = "History") }
                },
            )
        }
    ) { paddingValues ->
        Text(
            text = "サンプル",
            modifier = Modifier.padding(paddingValues)
        )
    }
}
