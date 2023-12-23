package com.example.lemoniceapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lemoniceapp.ui.theme.LemonICEAppTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonICEAppTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                MainNavHost(
                    navController = navController,
                    systemUiController = systemUiController
                )
            }
        }
    }
}

@Composable
fun MainNavHost(
    startDestination: String = MainScreenSpec.route,
    navController: NavHostController,
    systemUiController: SystemUiController
) {

    NavHost(
        navController = navController,
        startDestination = MainScreenSpec.route
    ) {
        MainNavScreenSpec.getAllMainNavScreenSpec().forEach { spec ->
            composable(
                route = spec.route,
                arguments = spec.arguments
            ) {
                spec.Content(
                    navController = navController,
                    navBackStackEntry = it,
                    systemUiController = systemUiController
                )
            }
        }
    }
}
