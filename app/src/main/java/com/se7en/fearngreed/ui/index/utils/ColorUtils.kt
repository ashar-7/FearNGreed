package com.se7en.fearngreed.ui.index.utils

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils.HSLToColor
import androidx.core.graphics.ColorUtils.colorToHSL

fun colorForPercentage(
    @FloatRange(from = 0.0, to = 1.0) value: Float,
    startColor: Color = Color.Red,
    endColor: Color = Color.Green
): Color =
    colorForPercentage(
        value = value,
        startHue = startColor.toFloatHSL().hue,
        endHue = endColor.toFloatHSL().hue
    )

fun colorForPercentage(
    @FloatRange(from = 0.0, to = 1.0) value: Float,
    @FloatRange(from = 0.0, to = 360.0) startHue: Float = 0f,
    @FloatRange(from = 0.0, to = 360.0) endHue: Float = 120f
): Color {
    val colorHue = (endHue - startHue) * value + startHue
    val hsl = FloatHSL(hue = colorHue, saturation = 1f, lightness = 0.5f, alpha = 1f)
    return hsl.toColor()
}

val Color.onColor: Color
    get() = if (luminance() > 0.5f) Color.Black else Color.White

data class FloatHSL(
    @FloatRange(from = 0.0, to = 360.0) val hue: Float,
    @FloatRange(from = 0.0, to = 1.0) val saturation: Float,
    @FloatRange(from = 0.0, to = 1.0) val lightness: Float,
    @FloatRange(from = 0.0, to = 1.0) val alpha: Float = 1f,
)

fun Color.toFloatHSL(): FloatHSL {
    val hslOut = floatArrayOf(0f, 0f, 0f)
    colorToHSL(toArgb(), hslOut)
    return FloatHSL(
        hslOut[0],
        hslOut[1],
        hslOut[2],
        alpha = alpha
    )
}

fun FloatHSL.toColor(): Color {
    val colorInt =
        HSLToColor(floatArrayOf(hue, saturation, lightness))
    return Color(colorInt).copy(alpha = alpha)
}
