package com.se7en.fearngreed.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.se7en.fearngreed.ui.index.AllIndexesScreen
import com.se7en.fearngreed.ui.index.CurrentIndexScreen
import com.se7en.fearngreed.ui.theme.FearNGreedTheme

@Composable
fun Root() {
    FearNGreedTheme {
        val viewModel = hiltViewModel<FearNGreedViewModel>()
        val navController = rememberNavController()

        NavHost(navController, startDestination = Screen.CurrentIndex.route) {
            composable(Screen.CurrentIndex.route) {
                CurrentIndexScreen(viewModel)
            }

            composable(Screen.AllIndexes.route) {
                AllIndexesScreen(viewModel)
            }
        }
    }
}
