package com.unfixedbo1t.calculator.simplecalculator.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val columnCount: Int
    if (isVerticalOrientation) {
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
    Box(modifier = modifier.background(Color.Blue)) {
        DigitButtonsGrid(
            buttons = buttons,
            columns = columnCount,
            onActionClick = onActionClick
        )
    }
}

@Composable
private fun DigitButtonsGrid(
    modifier: Modifier = Modifier,
    buttons: Array<ActionButtonType>,
    columns: Int,
    onActionClick: (ActionButtonState) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = columns),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(buttons) {
            ActionCalculatorButton(
                modifier = Modifier,
                type = it,
                onClick = onActionClick
            )
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
internal fun PreviewButtonsGridVertical() {
    CalculatorTheme {
        Surface {
            ButtonsGrid(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), onActionClick = {})
        }
    }
}

@Composable
@Preview
internal fun PreviewButtonsGridHorizontal() {
    CalculatorTheme {
        Surface {
            ButtonsGrid(
                modifier = Modifier
                    .wrapContentSize(),
                isVerticalOrientation = false,
                onActionClick = {}
            )
        }
    }
}