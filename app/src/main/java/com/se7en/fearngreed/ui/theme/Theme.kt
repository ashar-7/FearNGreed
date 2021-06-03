package com.se7en.fearngreed.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blue200,
    primaryVariant = Blue800,
    secondary = Blue200,
    secondaryVariant = Blue800,
    onPrimary = Color.White,
    onSecondary = Color.White,
    background = Gray900,
    surface = Gray900,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun FearNGreedTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
