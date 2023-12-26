package com.unfixedbo1t.calculator.simplecalculator.data

import com.unfixedbo1t.calculator.uikit.R
import com.unfixedbo1t.calculator.uikit.data.Icon

internal enum class ActionButtonType(
    val icon: Icon,
    val state: ActionButtonState
) {
    Plus(Icon.IconRes(R.drawable.plus_svgrepo_com), ActionButtonState.PLUS),
    Percent(Icon.IconRes(R.drawable.percent_svgrepo_com), ActionButtonState.PERCENT),
    Multiply(Icon.IconRes(R.drawable.multiply_svgrepo_com), ActionButtonState.MULTIPLY),
    Minus(Icon.IconRes(R.drawable.minus_svgrepo_com), ActionButtonState.MINUS),
    Equal(Icon.IconRes(R.drawable.equal_svgrepo_com), ActionButtonState.EQUAL),
    Divide(Icon.IconRes(R.drawable.divide_svgrepo_com), ActionButtonState.DIVIDE),
    Brackets(Icon.IconRes(R.drawable.divide_svgrepo_com), ActionButtonState.BRACKETS),
}

internal enum class ActionButtonState {
    PLUS,
    PERCENT,
    MULTIPLY,
    MINUS,
    EQUAL,
    DIVIDE,
    BRACKETS,
}