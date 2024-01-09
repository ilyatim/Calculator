package com.unfixedbo1t.calculator.di

import com.unfixedbo1t.calculator.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {
    viewModel {
        MainViewModel()
    }
}