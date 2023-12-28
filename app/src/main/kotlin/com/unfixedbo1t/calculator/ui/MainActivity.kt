package com.unfixedbo1t.calculator.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import com.unfixedbo1t.calculator.simplecalculator.ui.ButtonsGrid
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonsGrid(
                        modifier = Modifier.fillMaxSize(),
                        isVerticalOrientation = when (LocalConfiguration.current.orientation) {
                            Configuration.ORIENTATION_LANDSCAPE -> false
                            else -> true
                        }
                    ) {

                    }
                }
            }
        }
    }
}