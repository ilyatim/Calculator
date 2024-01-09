package com.unfixedbo1t.calculator.ui.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

internal class InputLayoutPreviewProvider : PreviewParameterProvider<Pair<String, String>> {
    override val values: Sequence<Pair<String, String>> = sequenceOf(
        Pair("", ""),
        Pair("1+1", "2"),
        Pair("1+2", "3"),
    )
}
