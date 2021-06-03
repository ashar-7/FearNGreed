package com.se7en.fearngreed.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun Chip(
    selected: Boolean,
    modifier: Modifier,
    selectedColor: Color,
    shape: Shape,
    contentPadding: PaddingValues = PaddingValues(8.dp, 4.dp),
    onSelect: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable(onClick = onSelect)
            .clip(shape)
            .background(if (selected) selectedColor else Color.Transparent)
            .padding(contentPadding),
    ) {
        content()
    }
}
