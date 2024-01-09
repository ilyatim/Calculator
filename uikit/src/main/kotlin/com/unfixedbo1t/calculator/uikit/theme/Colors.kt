package com.unfixedbo1t.calculator.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun getColorScheme(): ColorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme

internal val DarkColorScheme = darkColorScheme(
    primary = Dark.PrimaryGray,
    onPrimary = Dark.ButtonOnContainer,
    background = Dark.PrimaryDarkGray
)

internal val LightColorScheme = lightColorScheme(
    primary = Light.PrimaryGray,
    onPrimary = Light.ButtonOnContainer,
    background = Light.PrimaryLightGray,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)