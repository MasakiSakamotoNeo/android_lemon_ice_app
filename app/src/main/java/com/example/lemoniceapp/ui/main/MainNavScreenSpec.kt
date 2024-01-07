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
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.lemoniceapp.R
import com.example.lemoniceapp.ui.history.HistoryDetailScreen
import com.example.lemoniceapp.ui.history.HistoryViewModel
import com.example.lemoniceapp.ui.timeline.TimeLineDetailScreen
import com.example.lemoniceapp.ui.timeline.TimeLineViewModel
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

    override val route = "history_screen/{historyKey}"

    override val arguments = listOf(navArgument("historyKey") { type = NavType.StringType })

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {
        val historyKey = navBackStackEntry.arguments?.getString("historyKey", "") ?: ""
        // viewModelの生成
        val viewModel: HistoryViewModel = hiltViewModel()
        viewModel.navController = navController
        // History画面に遷移
        HistoryDetailScreen(
            historyKey,
            viewModel
        )
    }
}

/**
 * Work画面遷移仕様
 */
object WorkScreenSpec : MainNavScreenSpec {

    override val route = "work_screen/{workKey}"

    override val arguments = listOf(navArgument("workKey") { type = NavType.StringType })

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {
        val workKey = navBackStackEntry.arguments?.getString("workKey", "") ?: ""
        // viewModelの生成
        // TODO:
        // Work画面に遷移
        WorkDetailScreen(
            workKey
        )
    }
}

/**
 * TimeLine画面遷移仕様
 */
object TimeLineScreenSpec : MainNavScreenSpec {

    override val route = "timeline_screen/{timelineKey}"

    override val arguments = listOf(navArgument("timelineKey") { type = NavType.StringType })

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController
    ) {
        val timelineKey = navBackStackEntry.arguments?.getString("timelineKey", "") ?: ""
        // viewModelの生成
        val viewModel: TimeLineViewModel = hiltViewModel()
        viewModel.navController = navController
        // TimeLine画面に遷移
        TimeLineDetailScreen(
            timelineKey,
            viewModel
        )
    }
}
