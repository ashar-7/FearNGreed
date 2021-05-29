package com.se7en.fearngreed.ui

sealed class Screen(val route: String) {
    object CurrentIndex : Screen(route = "current_index")
    object AllIndexes : Screen(route = "all_indexes")
}
