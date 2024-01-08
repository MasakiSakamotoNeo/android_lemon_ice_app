package com.example.lemoniceapp.ui.main

import android.app.Activity
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.lemoniceapp.ui.history.HistoryDetailScreen
import com.example.lemoniceapp.ui.history.HistoryViewModel
import com.example.lemoniceapp.ui.theme.LemonICEAppTheme
import com.example.lemoniceapp.ui.timeline.TimeLineDetailScreen
import com.example.lemoniceapp.ui.timeline.TimeLineViewModel
import com.example.lemoniceapp.ui.top.TopScreen
import com.example.lemoniceapp.ui.work.WorkDetailScreen
import com.example.lemoniceapp.ui.work.WorkViewModel
import com.example.lemoniceapp.util.hideSystemUI
import com.example.lemoniceapp.util.showSystemUI
import com.google.accompanist.systemuicontroller.SystemUiController

sealed interface MainNavScreenSpec {

    companion object {

        fun getAllMainNavScreenSpec() = listOf(
            TopScreenSpec,
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
        systemUiController: SystemUiController,
        drawerState: DrawerState
    )
}

/**
 * TOP画面遷移仕様
 */
object TopScreenSpec : MainNavScreenSpec {

    override val route = "top_screen"

    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        systemUiController: SystemUiController,
        drawerState: DrawerState
    ) {
        val context = LocalContext.current
        val window = (context as Activity).window
        hideSystemUI(window)
        TopScreen { navController.navigate(MainScreenSpec.route) }
    }
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
        systemUiController: SystemUiController,
        drawerState: DrawerState
    ) {
        val context = LocalContext.current
        val window = (context as Activity).window
        // viewModelの生成
        val viewModel: MainViewModel = hiltViewModel()
        viewModel.apply {
            this.navController = navController
            this.drawerState = drawerState
        }

        showSystemUI(window)

        LemonICEAppTheme {
            // Main画面に遷移
            MainScreen(viewModel = viewModel)
        }
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
        systemUiController: SystemUiController,
        drawerState: DrawerState
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
        systemUiController: SystemUiController,
        drawerState: DrawerState
    ) {
        val workKey = navBackStackEntry.arguments?.getString("workKey", "") ?: ""
        // viewModelの生成
        val viewModel: WorkViewModel = hiltViewModel()
        viewModel.navController = navController
        // Work画面に遷移
        WorkDetailScreen(
            workKey,
            viewModel
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
        systemUiController: SystemUiController,
        drawerState: DrawerState
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
