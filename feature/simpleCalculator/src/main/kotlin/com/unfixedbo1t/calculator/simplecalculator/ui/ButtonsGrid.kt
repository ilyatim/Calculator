package com.unfixedbo1t.calculator.simplecalculator.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonState
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonType
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme

@Composable
fun ButtonsGrid(
    modifier: Modifier = Modifier,
    isVerticalOrientation: Boolean = true,
    onActionClick: (ActionButtonState) -> Unit,
) {
    val buttons: Array<ActionButtonType>
    val rowCount: Int
    val columnCount: Int
    if (isVerticalOrientation) {
        rowCount = 5
        columnCount = 4
        buttons = arrayOf(
            // First row
            ActionButtonType.Clear,
            ActionButtonType.Brackets,
            ActionButtonType.Percent,
            ActionButtonType.Divide,
            // Second row
            ActionButtonType.Seven,
            ActionButtonType.Eight,
            ActionButtonType.Nine,
            ActionButtonType.Multiply,
            // Third row
            ActionButtonType.Four,
            ActionButtonType.Five,
            ActionButtonType.Six,
            ActionButtonType.Minus,
            // Fourth row
            ActionButtonType.One,
            ActionButtonType.Two,
            ActionButtonType.Three,
            ActionButtonType.Plus,
            // Fifth row
            ActionButtonType.Zero,
            ActionButtonType.Point,
            ActionButtonType.Backspace,
            ActionButtonType.Calculate
        )
    } else {
        rowCount = 4
        columnCount = 5
        buttons = arrayOf(
            // First row
            ActionButtonType.Seven,
            ActionButtonType.Eight,
            ActionButtonType.Nine,
            ActionButtonType.Divide,
            ActionButtonType.Clear,
            // Second row
            ActionButtonType.Four,
            ActionButtonType.Five,
            ActionButtonType.Six,
            ActionButtonType.Multiply,
            ActionButtonType.Brackets,
            // Third row
            ActionButtonType.One,
            ActionButtonType.Two,
            ActionButtonType.Three,
            ActionButtonType.Minus,
            ActionButtonType.Divide,
            // Fourth row
            ActionButtonType.Zero,
            ActionButtonType.Point,
            ActionButtonType.Backspace,
            ActionButtonType.Plus,
            ActionButtonType.Calculate
        )
    }
    DigitButtonsGrid(
        modifier = modifier,
        buttons = buttons,
        columns = columnCount,
        rows = rowCount,
        onActionClick = onActionClick
    )
}

@Composable
private fun DigitButtonsGrid(
    modifier: Modifier = Modifier,
    buttons: Array<ActionButtonType>,
    columns: Int,
    rows: Int,
    onActionClick: (ActionButtonState) -> Unit
) {
    Column(modifier = modifier) {
        for (rowId in 0 until rows) {
            val firstIndex = rowId * columns

            Row {
                for (columnId in 0 until columns) {
                    val index = firstIndex + columnId
                    buttons.getOrNull(index)?.let {
                        ActionCalculatorButton(type = it, onClick = onActionClick)
                    }
                }
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
internal fun PreviewButtonsGridVertical() {
    CalculatorTheme {
        Surface {
            ButtonsGrid(onActionClick = {})
        }
    }
}

@Composable
@Preview
internal fun PreviewButtonsGridHorizontal() {
    CalculatorTheme {
        Surface {
            ButtonsGrid(isVerticalOrientation = false, onActionClick = {})
        }
    }
}