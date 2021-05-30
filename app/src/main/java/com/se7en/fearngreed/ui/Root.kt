package com.se7en.fearngreed.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.se7en.fearngreed.ui.index.AllIndexesScreen
import com.se7en.fearngreed.ui.index.CurrentIndexScreen
import com.se7en.fearngreed.ui.theme.FearNGreedTheme

@Composable
fun Root() {
    FearNGreedTheme {
        val systemUiController = rememberSystemUiController()
        val primaryVariant = MaterialTheme.colors.primaryVariant

        SideEffect {
            systemUiController.setStatusBarColor(color = primaryVariant)
        }

        val navController = rememberNavController()

        NavHost(navController, startDestination = Screen.CurrentIndex.route) {
            composable(Screen.CurrentIndex.route) {
                CurrentIndexScreen()
            }

            composable(Screen.AllIndexes.route) {
                AllIndexesScreen()
            }
        }
    }
}
