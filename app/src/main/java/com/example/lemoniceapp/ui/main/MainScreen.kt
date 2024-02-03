package com.example.lemoniceapp.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemoniceapp.R
import com.example.lemoniceapp.ui.main.component.HistorySection
import com.example.lemoniceapp.ui.main.component.TimeLineSection
import com.example.lemoniceapp.ui.main.component.VenueSection
import com.example.lemoniceapp.ui.main.component.WorksSection
import kotlinx.coroutines.launch

private val headerHeight = 250.dp
private val toolbarHeight = 56.dp

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {

    val coroutineScope = rememberCoroutineScope()

    MainUI(
        onEvent = {
            if (it == OnClickDrawerMenu) {
                coroutineScope.launch {
                    viewModel.drawerState?.open()
                }
            } else {
                viewModel.onEvent(it)
            }
        }
    )
}

@Composable
private fun MainUI(
    onEvent: (MainScreenEvent) -> Unit
) {

    Surface {
        CollapsingToolbarParallaxEffect(
            Modifier.fillMaxSize(),
            onEvent
        )
    }
}

@Composable
fun CollapsingToolbarParallaxEffect(
    modifier: Modifier = Modifier,
    onEvent: (MainScreenEvent) -> Unit = {}
) {
    val scroll: ScrollState = rememberScrollState()
    val headerHeightPx = with(LocalDensity.current) { headerHeight.toPx() }
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.toPx() }

    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .background(color = colorResource(R.color.lemon_ice_main_bg))
        ) {
            Header(
                scroll = scroll,
                headerHeightPx = headerHeightPx,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .height(headerHeight)
            )
            Body(
                scroll = scroll,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                onEvent = onEvent
            )
            Toolbar(
                scroll = scroll,
                headerHeightPx = headerHeightPx,
                toolbarHeightPx = toolbarHeightPx,
                onEvent = onEvent
            )
        }
    }
}

@Composable
private fun Header(
    scroll: ScrollState,
    headerHeightPx: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .graphicsLayer {
                translationY = -scroll.value.toFloat() / 2f
                alpha = (-1f / headerHeightPx) * scroll.value + 1
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.fig_ice),
            contentDescription = "header image",
            contentScale = ContentScale.FillBounds
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, colorResource(R.color.black2)),
                        startY = 3 * headerHeightPx / 4
                    )
                )
        )
    }
}

@Composable
private fun Body(
    scroll: ScrollState,
    modifier: Modifier = Modifier,
    onEvent: (MainScreenEvent) -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(scroll)
    ) {
        Spacer(Modifier.height(headerHeight))

        // 今までのICE
        HistorySection { onEvent(OnClickHistoryItem(it)) }

        // 今までの作品
        WorksSection { onEvent(OnClickWorkItem(it)) }

        // 会場
        VenueSection()

        // 今回のタイムライン
        TimeLineSection { onEvent(OnClickTimeLineItem(it)) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    scroll: ScrollState,
    headerHeightPx: Float,
    toolbarHeightPx: Float,
    modifier: Modifier = Modifier,
    onEvent: (MainScreenEvent) -> Unit
) {
    val toolbarBottom by remember {
        mutableStateOf(headerHeightPx - toolbarHeightPx)
    }

    val showToolbar by remember {
        derivedStateOf {
            scroll.value >= toolbarBottom
        }
    }

    AnimatedVisibility(
        modifier = modifier,
        visible = showToolbar,
        enter = fadeIn(animationSpec = tween(300)),
        exit = fadeOut(animationSpec = tween(300))
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(
                    onClick = { onEvent(OnClickDrawerMenu) },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(R.string.lemon_ice),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = colorResource(R.color.lemon_ice_green)
            )
        )
    }
}

@Preview
@Composable
fun Preview() {
    CollapsingToolbarParallaxEffect(
        modifier = Modifier
            .fillMaxSize()
    )
}
