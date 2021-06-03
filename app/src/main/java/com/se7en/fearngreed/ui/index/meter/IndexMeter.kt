package com.se7en.fearngreed.ui.index.meter

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.se7en.fearngreed.model.FGIndex
import kotlin.math.cos
import kotlin.math.sin

/**
 * Fear and Greed Index Meter
 * @param index Fear and Greed Index to show
 * @param modifier Required modifier for specifying canvas size
 * @param stroke Stroke width of the meter arc
 * @param handStroke Stroke width of the hand
 * @param handCircleRadius Radius of the hand's circular part
 * @param handColor Color for meter hand
 * @param gradientColorStops Colors and offsets to determine how the colors are dispersed throughout the meter
 */
@Composable
fun FGIndexMeter(
    index: FGIndex?,
    modifier: Modifier,
    stroke: Float? = null,
    handStroke: Float = 10f,
    handCircleRadius: Float = 20f,
    handColor: Color = MaterialTheme.colors.onBackground,
    gradientColorStops: List<Pair<Float, Color>> = listOf(
        0.5f to Color.Red,
        0.75f to Color.Yellow,
        1f to Color.Green
    )
) {
    val aspectRatio = 2f
    BoxWithConstraints {
        val strokeWidth = stroke ?: constraints.maxWidth / 12f
        val strokePadding = with(LocalDensity.current) { strokeWidth.toDp() / 2 }

        val progress by animatedProgress(index)

        Canvas(
            modifier = Modifier
                .padding(top = strokePadding, start = strokePadding, end = strokePadding)
                .then(modifier)
                .aspectRatio(aspectRatio)
        ) {
            drawArc(
                brush = Brush.sweepGradient(
                    *gradientColorStops.toTypedArray(),
                    center = Offset(center.x, size.height)
                ),
                startAngle = 0f,
                sweepAngle = -180f,
                useCenter = false,
                style = Stroke(width = strokeWidth),
                size = Size(size.width, size.height * aspectRatio)
            )

            val handCenter = Offset(
                x = size.width / 2f,
                y = size.height - handCircleRadius
            )
            val radius = size.width / 2f

            drawCircle(
                color = handColor,
                radius = handCircleRadius,
                center = handCenter
            )

            drawLine(
                color = handColor,
                start = handCenter,
                end = Offset(
                    x = handCenter.x + radius * cos(progressToRadians(progress)).toFloat(),
                    y = handCenter.y + radius * sin(progressToRadians(progress)).toFloat()
                ),
                strokeWidth = handStroke
            )
        }
    }
}

/**
 * Animates meter progress
 * @param index index data
 */
@Composable
private fun animatedProgress(index: FGIndex?): State<Float> {
    val progress = remember { Animatable(0f) }
    LaunchedEffect(index) {
        if (index != null) {
            progress.animateTo(
                targetValue = index.value.toFloat(),
                animationSpec = ProgressToIndexSpec
            )
        } else {
            progress.animateTo(
                targetValue = 100f,
                animationSpec = ProgressInfiniteSpec
            )
        }
    }

    return progress.asState()
}

private val ProgressToIndexSpec = spring<Float>(
    Spring.DampingRatioMediumBouncy,
    stiffness = Spring.StiffnessVeryLow
)

private val ProgressInfiniteSpec = infiniteRepeatable<Float>(
    animation = keyframes {
        durationMillis = 800
        0f at 0 with FastOutSlowInEasing
        100f at 800 with FastOutSlowInEasing
    },
    repeatMode = RepeatMode.Reverse
)

@Preview
@Composable
fun FGIndexMeterPreview() {
    FGIndexMeter(index = null, modifier = Modifier.width(200.dp))
}
