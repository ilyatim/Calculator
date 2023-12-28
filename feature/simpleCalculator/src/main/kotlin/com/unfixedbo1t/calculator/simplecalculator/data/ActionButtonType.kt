package com.unfixedbo1t.calculator.simplecalculator.data

import com.unfixedbo1t.calculator.uikit.R
import com.unfixedbo1t.calculator.uikit.data.Icon
import com.unfixedbo1t.calculator.uikit.data.IconRes
import com.unfixedbo1t.calculator.uikit.data.IconString

internal enum class ActionButtonType(
    val icon: Icon,
    val state: ActionButtonState
) {
    Plus(IconRes(R.drawable.plus_svgrepo_com), ActionButtonState.Plus),
    Percent(IconRes(R.drawable.percent_svgrepo_com), ActionButtonState.Percent),
    Multiply(IconRes(R.drawable.multiply_svgrepo_com), ActionButtonState.Multiply),
    Minus(IconRes(R.drawable.minus_svgrepo_com), ActionButtonState.Minus),
    Calculate(IconRes(R.drawable.equal_svgrepo_com), ActionButtonState.Calculate),
    Divide(IconRes(R.drawable.divide_svgrepo_com), ActionButtonState.Divide),
    Brackets(IconRes(R.drawable.brackets_round_svgrepo_com), ActionButtonState.Brackets),
    Backspace(IconRes(R.drawable.baseline_backspace_24), ActionButtonState.Backspace),
    Clear(IconString("AC"), ActionButtonState.Clear),
    Point(IconString("."), ActionButtonState.Point),
    Zero(IconString("0"), ActionButtonState.Digit(0)),
    One(IconString("1"), ActionButtonState.Digit(1)),
    Two(IconString("2"), ActionButtonState.Digit(2)),
    Three(IconString("3"), ActionButtonState.Digit(3)),
    Four(IconString("4"), ActionButtonState.Digit(4)),
    Five(IconString("5"), ActionButtonState.Digit(5)),
    Six(IconString("6"), ActionButtonState.Digit(6)),
    Seven(IconString("7"), ActionButtonState.Digit(7)),
    Eight(IconString("8"), ActionButtonState.Digit(8)),
    Nine(IconString("9"), ActionButtonState.Digit(9)),
}

sealed class ActionButtonState {
    data object Plus : ActionButtonState()

    data object Percent : ActionButtonState()

    data object Multiply : ActionButtonState()

    data object Minus : ActionButtonState()

    data object Calculate : ActionButtonState()

    data object Divide : ActionButtonState()

    data object Brackets : ActionButtonState()

    data object Clear : ActionButtonState()

    data object Point : ActionButtonState()

    data object Backspace : ActionButtonState()

    data class Digit(val digit: Int) : ActionButtonState()
}