package com.se7en.fearngreed.ui.index

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun CurrentIndexScreen(viewModel: CurrentIndexViewModel) {
    val uiState by remember(viewModel) { viewModel.uiState }.collectAsState()

}
