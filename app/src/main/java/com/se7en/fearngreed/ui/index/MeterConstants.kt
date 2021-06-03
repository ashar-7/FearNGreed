package com.se7en.fearngreed.ui.index

import androidx.compose.ui.graphics.Color

val MeterStartColor = Color.Red
val MeterMidColor = Color.Yellow
val MeterEndColor = Color.Green
val MeterGradientColorStops = listOf(
    0.5f to MeterStartColor,
    0.75f to MeterMidColor,
    1f to MeterEndColor
)
