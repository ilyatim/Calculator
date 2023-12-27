package com.unfixedbo1t.calculator.simplecalculator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonState
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonType
import com.unfixedbo1t.calculator.uikit.components.DefaultCalculatorButton
import com.unfixedbo1t.calculator.uikit.data.Icon
import com.unfixedbo1t.calculator.uikit.data.IconDrawable
import com.unfixedbo1t.calculator.uikit.data.IconRes
import com.unfixedbo1t.calculator.uikit.data.IconString
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme

@Composable
internal fun ActionCalculatorButton(
    modifier: Modifier = Modifier,
    type: ActionButtonType,
    onClick: (ActionButtonState) -> Unit,
) {
    DefaultCalculatorButton(
        modifier = modifier,
        onClick = {
            onClick.invoke(type.state)
        }
    ) {
        when (type.icon) {
            is IconDrawable -> Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = type.icon.iconDrawable,
                contentDescription = null
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

@Preview
@Composable
private fun PreviewActionButtons(
    @PreviewParameter(ButtonsProvider::class) buttons: ActionButtonType
) {
    CalculatorTheme {
        ActionCalculatorButton(type = buttons, onClick = {})
    }
}
