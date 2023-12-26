package com.unfixedbo1t.calculator.simplecalculator.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonType

internal class ButtonsProvider : PreviewParameterProvider<ActionButtonType> {
    override val values: Sequence<ActionButtonType> = sequenceOf(
        ActionButtonType.Equal,
        ActionButtonType.Plus,
        ActionButtonType.Minus,
        ActionButtonType.Multiply,
        ActionButtonType.Divide
    )
}