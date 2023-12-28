package com.unfixedbo1t.calculator.simplecalculator.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = modifier
            .heightIn(70.dp, 100.dp)
            .widthIn(70.dp, 100.dp),
        backgroundColor = getButtonColor(type = type),
        onClick = {
            onClick.invoke(type.state)
        }
    ) {
        when (type.icon) {
            is IconDrawable -> Icon(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                imageVector = type.icon.iconDrawable,
                contentDescription = null,
            )

            is IconRes -> Icon(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                painter = painterResource(id = type.icon.iconRes),
                contentDescription = null
            )

            is IconString -> {
                val style = TextStyle(
                    color = LocalContentColor.current,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    letterSpacing = 0.sp
                )
                BasicText(
                    text = type.icon.text,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .padding(top = 3.dp),
                    style = style,
                    //textAlign = TextAlign.Center,
                    //fontSize = TextUnit(30.0f, TextUnitType.Sp),
                    maxLines = 1,
                )
            }
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
