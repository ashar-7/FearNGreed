package com.se7en.fearngreed.ui.index

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.se7en.fearngreed.ui.index.utils.colorForPercentage
import com.se7en.fearngreed.ui.index.utils.onColor

private fun defaultIndexColor(index: Int) = colorForPercentage(
    value = index / 100f,
    startColor = MeterStartColor,
    endColor = MeterEndColor
)

@Composable
fun Index(
    modifier: Modifier = Modifier,
    value: Int,
    classification: String,
    time: String,
    color: Color = defaultIndexColor(value),
    onColor: Color = color.onColor
) {
    ProvideTextStyle(MaterialTheme.typography.subtitle1) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = time,
                    fontWeight = FontWeight.Medium
                )
                Text(text = classification, color = color)
            }

            Spacer(modifier = Modifier.width(18.dp))

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(color)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value.toString(),
                    color = onColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun IndexPreview() {
    Index(
        value = 100,
        classification = "Extreme Greed",
        time = "Now",
        color = Color.Green,
    )
}
