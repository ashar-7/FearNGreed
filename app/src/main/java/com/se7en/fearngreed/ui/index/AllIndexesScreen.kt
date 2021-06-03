package com.se7en.fearngreed.ui.index

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.se7en.fearngreed.model.FGIndex
import com.se7en.fearngreed.ui.index.utils.getDateString

@Composable
fun AllIndexesScreen(viewModel: AllIndexesViewModel) {
    val uiState = remember(viewModel) { viewModel.uiState }.collectAsState()

    when (val state = uiState.value) {
        IndexUIState.Idle -> {
        }
        IndexUIState.Loading -> {
            LoadingContent()
        }
        is IndexUIState.Success -> {
            AllIndexes(state.data)
        }
        is IndexUIState.Error -> {
        }
    }
}

@Composable
private fun AllIndexes(data: List<FGIndex>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data) { index ->
            IndexItem(index)
        }
    }
}

@Composable
private fun IndexItem(index: FGIndex) {
    Row {
        Column {
            Text(
                text = getDateString(index.timestamp),
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                text = index.classification,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun IndexItemPreview() {
    IndexItem(
        index = FGIndex(
            timeUntilUpdate = null,
            timestamp = System.currentTimeMillis(),
            value = 18,
            classification = "Extreme Fear"
        )
    )
}

@Composable
private fun LoadingContent() {

}
