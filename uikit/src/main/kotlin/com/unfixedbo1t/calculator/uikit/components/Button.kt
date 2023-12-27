package com.unfixedbo1t.calculator.uikit.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme
import com.unfixedbo1t.calculator.uikit.theme.clearButtonColor
import com.unfixedbo1t.calculator.uikit.theme.digitButtonColor

@Composable
fun DefaultCalculatorButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier
            .height(60.dp)
            .width(60.dp),
        onClick = onClick,
    ) {
        content()
    }
}

@Composable
fun DigitCalculatorButton(
    modifier: Modifier = Modifier,
    digit: Int,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    DefaultCalculatorButton(
        modifier = modifier,
        onClick = onClick,
        backgroundColor = backgroundColor
    ) {
        Text(
            modifier = Modifier,
            textAlign = TextAlign.Center,
            text = digit.toString(),
            fontSize = 18.sp
        )
    }
}

@Composable
fun ClearCalculatorButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    DefaultCalculatorButton(
        modifier = modifier,
        onClick = onClick,
        backgroundColor = backgroundColor
    ) {
        Text(
            modifier = Modifier,
            textAlign = TextAlign.Center,
            text = "AC",
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
private fun DefaultCalculatorButtonPreview() {
    CalculatorTheme {
        DigitCalculatorButton(
            digit = 1,
            backgroundColor = digitButtonColor,
            onClick = {},
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
private fun ClearCalculatorButtonPreview() {
    CalculatorTheme {
        ClearCalculatorButton(
            backgroundColor = clearButtonColor,
            onClick = {},
        )
    }
}