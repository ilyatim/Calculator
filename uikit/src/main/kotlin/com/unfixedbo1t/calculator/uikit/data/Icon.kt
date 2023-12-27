package com.unfixedbo1t.calculator.uikit.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Icon

data class IconRes(@DrawableRes val iconRes: Int) : Icon()

data class IconDrawable(val iconDrawable: ImageVector) : Icon()

data class IconString(val text: String) : Icon()