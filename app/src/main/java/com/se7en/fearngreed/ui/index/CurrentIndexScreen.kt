package com.se7en.fearngreed.ui.index

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.se7en.fearngreed.R
import com.se7en.fearngreed.model.FGIndex
import com.se7en.fearngreed.ui.index.meter.FGIndexMeter
import com.se7en.fearngreed.ui.index.utils.colorForPercentage
import com.se7en.fearngreed.ui.index.utils.getDateString

private val DefaultMeterWidth = 250.dp
private val MeterStartColor = Color.Red
private val MeterMidColor = Color.Yellow
private val MeterEndColor = Color.Green
private val MeterGradientColorStops = listOf(
    0.5f to MeterStartColor,
    0.75f to MeterMidColor,
    1f to MeterEndColor
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CurrentIndexScreen(viewModel: CurrentIndexViewModel) {
    val uiState by remember(viewModel) { viewModel.uiState }.collectAsState()

    val index = (uiState as? IndexUIState.Success)?.data

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.current_index_top_bar_title)) },
                elevation = 0.dp
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            FGIndexMeter(
                index = index,
                modifier = Modifier.width(DefaultMeterWidth),
                stroke = 50f,
                gradientColorStops = MeterGradientColorStops
            )

            AnimatedVisibility(
                visible = index != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                if (index != null) {
                    SuccessContent(
                        index = index,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Composable
private fun SuccessContent(index: FGIndex, modifier: Modifier) {
    val indexColor = colorForPercentage(
        value = index.value / 100f,
        startColor = MeterStartColor,
        endColor = MeterEndColor
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Index(
            modifier = Modifier
                .widthIn(min = DefaultMeterWidth),
            value = index.value,
            classification = index.classification,
            time = stringResource(R.string.now),
            color = indexColor
        )

        Text(
            text = stringResource(
                R.string.last_updated_date,
                getDateString(timestamp = index.timestamp)
            ),
            style = MaterialTheme.typography.caption,
            modifier = Modifier.align(Alignment.End)
        )
    }
}
