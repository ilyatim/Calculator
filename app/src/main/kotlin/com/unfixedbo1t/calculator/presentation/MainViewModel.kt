package com.unfixedbo1t.calculator.presentation

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : ContainerHost<UiState, SideEffect>, ViewModel() {
    override val container: Container<UiState, SideEffect> = container(UiState())
    fun addSymbol(newString: Char) = intent {
        reduce {
            state.copy(input = state.input + newString)
        }
    }

    fun removeSymbol() = intent {
        if (state.input.isNotEmpty()) {
            reduce {
                state.copy(input = state.input.dropLast(1))
            }
        }
    }
}

data class UiState(
    val input: String = "",
    val result: String = ""
)

sealed interface SideEffect {

}