package com.unfixedbo1t.calculator.uikit.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme

@Composable
fun DefaultCalculatorButton(
    modifier: Modifier = Modifier,
    //backgroundColor: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        //colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
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
    //backgroundColor: Color,
    onClick: () -> Unit,
) {
    DefaultCalculatorButton(
        modifier = modifier,
        onClick = onClick,
        //backgroundColor = backgroundColor
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
    //backgroundColor: Color,
    onClick: () -> Unit,
) {
    DefaultCalculatorButton(
        modifier = modifier,
        onClick = onClick,
        //backgroundColor = backgroundColor
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

@Preview
@Composable
fun DefaultCalculatorButtonPreview() {
    CalculatorTheme {
        DigitCalculatorButton(
            digit = 1,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun ClearCalculatorButtonPreview() {
    CalculatorTheme {
        ClearCalculatorButton(
            onClick = {},
        )
    }
}