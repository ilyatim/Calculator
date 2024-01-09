package com.unfixedbo1t.calculator.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.unfixedbo1t.calculator.presentation.MainViewModel
import com.unfixedbo1t.calculator.presentation.SideEffect
import com.unfixedbo1t.calculator.presentation.UiState
import com.unfixedbo1t.calculator.simplecalculator.data.ActionButtonState
import com.unfixedbo1t.calculator.simplecalculator.ui.ButtonsGrid
import com.unfixedbo1t.calculator.uikit.theme.getColorScheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ComposeApp(
    windowSizeClass: WindowSizeClass,
    appState: AppState = rememberAppState(windowSizeClass = windowSizeClass),
    viewModel: MainViewModel = koinViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect(::handleSideEffect)
    }

    val state = viewModel.container.stateFlow.collectAsState()

    val buttonCallback: (ActionButtonState) -> Unit = {
        when (it) {
            is ActionButtonState.Digit -> viewModel.addSymbol(it.digit.toChar())
            ActionButtonState.Backspace -> {

            }

            ActionButtonState.Brackets -> {

            }

            ActionButtonState.Calculate -> {

            }

            ActionButtonState.Clear -> {

            }

            ActionButtonState.Divide -> {

            }

            ActionButtonState.Minus -> {

            }

            ActionButtonState.Multiply -> {

            }

            ActionButtonState.Percent -> {

            }

            ActionButtonState.Plus -> {

            }

            ActionButtonState.Point -> {

            }
        }
    }

    MainScreen(state = state, onActionClick = buttonCallback)
}

@Composable
fun MainScreen(
    state: State<UiState>,
    onActionClick: (ActionButtonState) -> Unit,
) {
    /*Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        color = MaterialTheme.colorScheme.background
    ) {*/
    val isVertical = when (LocalConfiguration.current.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> false
        else -> true
    }

    val inputId = "inputId"
    val buttonsId = "buttonsId"

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = getColorScheme().background)
            .statusBarsPadding()
            .navigationBarsPadding(),
        constraintSet = getMainScreenConstraintSet(
            inputId = inputId,
            buttonsId = buttonsId
        )
    ) {
        InputLayout(
            modifier = Modifier
                .layoutId(inputId),
            input = state.value.input,
            result = state.value.result,
        )

        ButtonsGrid(
            modifier = Modifier
                .layoutId(buttonsId),
            isVerticalOrientation = isVertical,
            onActionClick = onActionClick
        )
    }
    //}
}

@Suppress("SameParameterValue")
private fun getMainScreenConstraintSet(
    inputId: String,
    buttonsId: String
): ConstraintSet = ConstraintSet {
    val input = createRefFor(inputId)
    val buttons = createRefFor(buttonsId)

    constrain(input) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
    constrain(buttons) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)
    }
}


private fun handleSideEffect(sideEffect: SideEffect) {

}