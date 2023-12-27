package com.unfixedbo1t.calculator.simplecalculator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonState
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonType
import com.unfixedbo1t.calculator.uikit.components.DefaultCalculatorButton
import com.unfixedbo1t.calculator.uikit.data.IconDrawable
import com.unfixedbo1t.calculator.uikit.data.IconRes
import com.unfixedbo1t.calculator.uikit.data.IconString
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme
import com.unfixedbo1t.calculator.uikit.theme.actionButtonColor
import com.unfixedbo1t.calculator.uikit.theme.clearButtonColor
import com.unfixedbo1t.calculator.uikit.theme.digitButtonColor

@Composable
internal fun ActionCalculatorButton(
    modifier: Modifier = Modifier,
    type: ActionButtonType,
    onClick: (ActionButtonState) -> Unit,
) {
    DefaultCalculatorButton(
        modifier = modifier,
        backgroundColor = getButtonColor(type = type),
        onClick = {
            onClick.invoke(type.state)
        }
    ) {
        when (type.icon) {
            is IconDrawable -> Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = type.icon.iconDrawable,
                contentDescription = null,
            )

            is IconRes -> Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = type.icon.iconRes),
                contentDescription = null
            )

            is IconString -> Text(
                //modifier = Modifier.fillMaxSize(),
                text = type.icon.text
            )
        }
    }
}

@Composable
private fun getButtonColor(type: ActionButtonType): Color {
    return when (type) {
        ActionButtonType.Clear -> {
            clearButtonColor
        }

        ActionButtonType.Zero, ActionButtonType.One, ActionButtonType.Two,
        ActionButtonType.Three, ActionButtonType.Four, ActionButtonType.Five,
        ActionButtonType.Six, ActionButtonType.Seven, ActionButtonType.Eight,
        ActionButtonType.Nine, ActionButtonType.Point, ActionButtonType.Backspace -> {
            digitButtonColor
        }

        else -> {
            actionButtonColor
        }
    }
}

@Preview
@Composable
private fun PreviewActionButtons(
    @PreviewParameter(ButtonsProvider::class) buttons: ActionButtonType
) {
    CalculatorTheme {
        ActionCalculatorButton(type = buttons, onClick = {})
    }
}
