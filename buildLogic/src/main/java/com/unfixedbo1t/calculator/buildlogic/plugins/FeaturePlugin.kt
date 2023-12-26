package com.unfixedbo1t.calculator.buildlogic.plugins

import com.android.build.api.dsl.LibraryExtension
import com.unfixedbo1t.calculator.buildlogic.extensions.configurePrimaryComposeAndroid
import com.unfixedbo1t.calculator.buildlogic.extensions.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.unfixedbo1t.android.calculator.library")
                apply("com.unfixedbo1t.android.calculator.di")
            }
            /**
             * Android
             */
            dependencies {
                implementation(libs.findLibrary("androidx.lifecycle.viewmodel").get())
                implementation(libs.findLibrary("androidx.compose.constraintLayout").get())
                implementation(libs.findLibrary("androidx.compose.lifecycle.runtime").get())
                implementation(libs.findLibrary("koin.androidx.compose").get())
                implementation(libs.findLibrary("orbit.mvi.core").get())
                implementation(project(":uikit"))
            }

            val kotlinCompileExtensionVersion =
                libs.findVersion("kotlin.compose").get().requiredVersion
            extensions.configure<LibraryExtension> {
                configurePrimaryComposeAndroid(this, kotlinCompileExtensionVersion)
            }
        }
    }
}