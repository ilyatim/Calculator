package com.unfixedbo1t.calculator.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultCalculatorButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .surface(
                shape = CircleShape,
                backgroundColor = backgroundColor,
                border = null,
                shadowElevation = 0.dp
            )
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                enabled = true,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

fun Modifier.surface(
    shape: Shape,
    backgroundColor: Color,
    border: BorderStroke?,
    shadowElevation: Dp
) = this
    .shadow(shadowElevation, shape, clip = false)
    .then(if (border != null) Modifier.border(border, shape) else Modifier)
    .background(color = backgroundColor, shape = shape)
    .clip(shape)

