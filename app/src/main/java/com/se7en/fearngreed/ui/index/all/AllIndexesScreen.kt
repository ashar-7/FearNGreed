package com.se7en.fearngreed.ui.index.all

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.se7en.fearngreed.model.FGIndex
import com.se7en.fearngreed.ui.index.Index
import com.se7en.fearngreed.ui.index.IndexUIState
import com.se7en.fearngreed.ui.index.utils.getDateString

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AllIndexesScreen(viewModel: AllIndexesViewModel, onNavigateUp: () -> Unit) {
    val uiState = remember(viewModel) { viewModel.uiState }.collectAsState()

    Scaffold(
        topBar = { AllIndexesTopBar(onNavigateUp = onNavigateUp) }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {
            when (val state = uiState.value) {
                IndexUIState.Idle -> {
                }
                IndexUIState.Loading -> {
                    LoadingContent(modifier = Modifier.fillMaxSize())
                }
                is IndexUIState.Success -> {
                    Spacer(modifier = Modifier.height(8.dp))
                    AllIndexes(state.data, modifier = Modifier.fillMaxSize())
                }
                is IndexUIState.Error -> {
                }
            }

        }
    }
}

@Composable
private fun AllIndexes(data: List<FGIndex>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data) { index ->
            Index(
                value = index.value,
                classification = index.classification,
                time = getDateString(index.timestamp) + ":",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 2.dp)
            )
        }
    }
}

@Composable
private fun LoadingContent(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
