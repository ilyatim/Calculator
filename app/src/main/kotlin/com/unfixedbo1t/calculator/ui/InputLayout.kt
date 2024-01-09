package com.unfixedbo1t.calculator.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.unfixedbo1t.calculator.ui.provider.InputLayoutPreviewProvider
import com.unfixedbo1t.calculator.uikit.components.surface
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme
import com.unfixedbo1t.calculator.uikit.theme.getColorScheme

@Composable
fun InputLayout(
    modifier: Modifier = Modifier,
    input: String,
    result: String
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .surface(
                shape = RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp),
                backgroundColor = getColorScheme().primary,
                null,
                0.dp
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
        ) {
            val default = TextStyle.Default.copy(color = getColorScheme().onPrimary)

            Text(
                modifier = Modifier.heightIn(50.dp, 100.dp),
                text = input,
                style = default
            )
            Text(
                modifier = Modifier.heightIn(50.dp, 100.dp),
                text = result,
                style = default
            )
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun InputLayoutPreview(
    @PreviewParameter(InputLayoutPreviewProvider::class) pair: Pair<String, String>
) {
    CalculatorTheme {
        InputLayout(
            modifier = Modifier.size(100.dp),
            input = pair.first,
            result = pair.second
        )
    }
}