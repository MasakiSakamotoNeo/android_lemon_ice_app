package com.example.lemoniceapp.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.lemoniceapp.R
import com.example.lemoniceapp.ui.history.HistoryDetailScreen
import com.example.lemoniceapp.ui.timeline.TimeLineDetailScreen
import com.example.lemoniceapp.ui.work.WorkDetailScreen
import com.google.accompanist.systemuicontroller.SystemUiController

sealed interface MainNavScreenSpec {

    companion object {

        fun getAllMainNavScreenSpec() = listOf(
            MainScreenSpec,
            HistoryScreenSpec,
            WorkScreenSpec,
            TimeLineScreenSpec
        )
    }

    val route: String

    val arguments: List<NamedNavArgument> get() = emptyList()

    @Composable
    fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    )
}

/**
 * メイン画面遷移仕様
 */
object MainScreenSpec : MainNavScreenSpec {

    override val route = "main_screen"

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {
        val context = LocalContext.current
        // viewModelの生成
        val viewModel: MainViewModel = hiltViewModel()
        viewModel.navController = navController

        // ステータスバーカラー変更
        SideEffect {
            Color(ContextCompat.getColor(context, R.color.lemon_ice_green)).let {
                systemUiController.setStatusBarColor(color = it, darkIcons = false)
            }
        }

        // Main画面に遷移
        MainScreen(viewModel = viewModel)
    }
}

/**
 * History画面遷移仕様
 */
object HistoryScreenSpec : MainNavScreenSpec {

    override val route = "history_screen"

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {

        // History画面に遷移
        HistoryDetailScreen()
    }
}

/**
 * Work画面遷移仕様
 */
object WorkScreenSpec : MainNavScreenSpec {

    override val route = "work_screen"

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {

        // Work画面に遷移
        WorkDetailScreen()
    }
}

/**
 * TimeLine画面遷移仕様
 */
object TimeLineScreenSpec : MainNavScreenSpec {

    override val route = "timeline_screen"

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {

        // TimeLine画面に遷移
        TimeLineDetailScreen()
    }
}
