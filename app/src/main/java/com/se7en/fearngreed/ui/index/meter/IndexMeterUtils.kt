package com.se7en.fearngreed.ui.index.meter

import kotlin.math.PI

fun progressToRadians(
    progress: Float,
    progressRange: ClosedFloatingPointRange<Float> = (0f..100f),
    angleRange: ClosedFloatingPointRange<Float> = (180f..360f)
): Double =
    toRadians(
        progressRange.convert(progress, angleRange)
    )

fun toRadians(angle: Float): Double = angle * PI / 180f

fun ClosedFloatingPointRange<Float>.convert(
    number: Float,
    target: ClosedFloatingPointRange<Float>
): Float {
    val ratio = number / (endInclusive - start)
    return (ratio * (target.endInclusive - target.start) + target.start)
}
