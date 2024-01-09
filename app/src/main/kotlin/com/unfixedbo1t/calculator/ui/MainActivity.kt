package com.unfixedbo1t.calculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.unfixedbo1t.calculator.uikit.theme.CalculatorTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            // Mocked
            val darkTheme = true

            CalculatorTheme(
                darkTheme = darkTheme
            ) {
                ComposeApp(windowSizeClass = calculateWindowSizeClass(this))
            }
        }
    }
}