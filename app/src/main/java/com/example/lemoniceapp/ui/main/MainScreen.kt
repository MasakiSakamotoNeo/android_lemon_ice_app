package com.example.lemoniceapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lemoniceapp.R
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    // TODO:
    MainUI(onEvent = { viewModel.onEvent(it) }) 
}

@Composable
fun MainUI(
    onEvent: (MainScreenEvent) -> Unit
) {

    val collapsingState = rememberCollapsingToolbarScaffoldState()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = collapsingState,
            scrollStrategy = ScrollStrategy.EnterAlways,
            toolbar = {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.dp)
                        .pin()
                        .background(color = colorResource(id = R.color.lemon_ice_green))
                )

                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.lemon_ice),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    alpha = 1f
                )
            },
            body = {
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(100) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(text = "Sample")
                            }
                        }
                    }
                }
            }
        )
        val height = 64 * context.resources.displayMetrics.density
        if (collapsingState.toolbarState.height <= height) {
            Column(
                modifier = Modifier
                    .background(colorResource(id = R.color.lemon_ice_green))
                    .height(64.dp)
                    .fillMaxWidth()
            ) {}
        }
    }
}
