package com.example.lemoniceapp.ui.top

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lemoniceapp.ui.main.MainNavScreenSpec
import com.example.lemoniceapp.ui.main.TopScreenSpec
import com.example.lemoniceapp.ui.theme.LemonICEAppTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            LemonICEAppTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        // ドロワーメニューコンテンツ
                        ModalDrawerSheet {
                            Text(text = "サンプル")
                        }
                    }
                ) {
                    MainNavHost(
                        navController = navController,
                        systemUiController = systemUiController,
                        drawerState = drawerState
                    )
                }
            }
        }
    }
}

@Composable
fun MainNavHost(
    startDestination: String = TopScreenSpec.route,
    navController: NavHostController,
    systemUiController: SystemUiController,
    drawerState: DrawerState
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        MainNavScreenSpec.getAllMainNavScreenSpec().forEach { spec ->
            composable(
                route = spec.route,
                arguments = spec.arguments
            ) {
                spec.Content(
                    navController = navController,
                    navBackStackEntry = it,
                    systemUiController = systemUiController,
                    drawerState = drawerState
                )
            }
        }
    }
}
