package com.se7en.fearngreed.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.se7en.fearngreed.ui.index.AllIndexesScreen
import com.se7en.fearngreed.ui.index.AllIndexesViewModel
import com.se7en.fearngreed.ui.index.CurrentIndexScreen
import com.se7en.fearngreed.ui.index.CurrentIndexViewModel
import com.se7en.fearngreed.ui.theme.FearNGreedTheme

@Composable
fun Root() {
    FearNGreedTheme {
        val systemUiController = rememberSystemUiController()
        val primaryVariant = MaterialTheme.colors.primaryVariant

        SideEffect {
            systemUiController.setStatusBarColor(color = primaryVariant)
        }

        Surface {
            NavGraph()
        }
    }
}

@Composable
private fun NavGraph() {
    val navController = rememberNavController()

    val currentIndexViewModel = hiltViewModel<CurrentIndexViewModel>()
    val allIndexesViewModel = hiltViewModel<AllIndexesViewModel>()

    NavHost(navController, startDestination = Screen.CurrentIndex.route) {
        composable(Screen.CurrentIndex.route) {
            CurrentIndexScreen(
                viewModel = currentIndexViewModel,
                onViewAllIndexes = { navController.navigate(Screen.AllIndexes.route) }
            )
        }

        composable(Screen.AllIndexes.route) {
            AllIndexesScreen(viewModel = allIndexesViewModel)
        }
    }
}
