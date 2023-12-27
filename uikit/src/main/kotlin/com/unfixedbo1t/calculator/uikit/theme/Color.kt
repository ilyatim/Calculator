package com.unfixedbo1t.calculator.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val clearButtonColor: Color
    @Composable get() = if (isSystemInDarkTheme()) {
        Dark.ButtonClearContainer
    } else {
        Light.ButtonClearContainer
    }

val digitButtonColor: Color
    @Composable get() = if (isSystemInDarkTheme()) {
        Dark.ButtonDigitContainer
    } else {
        Light.ButtonDigitContainer
    }

val actionButtonColor: Color
    @Composable get() = if (isSystemInDarkTheme()) {
        Dark.ButtonActionContainer
    } else {
        Light.ButtonActionContainer
    }


object Light {
    val PrimaryGray = Color(0xFFe1e3f1)
    val PrimaryLightGray = Color(0xFFfaf9ff)
    val ButtonActionContainer = Color(0xFFdbe2fc)
    val ButtonDigitContainer = Color(0xFFecf1fb)
    val ButtonEqualsContainer = ButtonActionContainer
    val ButtonClearContainer = Color(0xFFffd5ff)
    val ButtonOnContainer = Color(0xFF141d32)
    val ButtonClearOnContainer = ButtonOnContainer
}

object Dark {
    val PrimaryGray = Color(0xFF262b38)
    val PrimaryDarkGray = Color(0xFF121318)
    val ButtonActionContainer = Color(0xFF3e475b)
    val ButtonDigitContainer = Color(0xFF171c26)
    val ButtonEqualsContainer = Color(0xFF20477c)
    val ButtonClearContainer = Color(0xFF5c3d5d)
    val ButtonOnContainer = Color(0xFFdce3fd)
    val ButtonClearOnContainer = Color(0xFFffdaff)
}