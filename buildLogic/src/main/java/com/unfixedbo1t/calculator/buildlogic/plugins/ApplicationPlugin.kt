package com.unfixedbo1t.calculator.buildlogic.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.unfixedbo1t.calculator.buildlogic.extensions.configureKotlinAndroid
import com.unfixedbo1t.calculator.buildlogic.extensions.configurePrimaryComposeAndroid
import com.unfixedbo1t.calculator.buildlogic.extensions.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.unfixedbo1t.android.calculator.di")
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            val minSdk = libs.findVersion("android.minSdkVersion").get().requiredVersion
            val compileSdk = libs.findVersion("android.compileSdkVersion").get().requiredVersion
            val targetSdk = libs.findVersion("android.targetSdkVersion").get().requiredVersion
            val kotlinCompileExtensionVersion =
                libs.findVersion("kotlin.compose").get().requiredVersion
            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = targetSdk.toInt()
                configureKotlinAndroid(this, compileSdk.toInt(), minSdk.toInt())
            }

            dependencies {
                implementation(libs.findLibrary("androidx.activity.compose").get())
                implementation(libs.findLibrary("androidx.compose.lifecycle.runtime").get())
                implementation(libs.findLibrary("koin.androidx.compose").get())
                implementation(libs.findLibrary("orbit.mvi.core").get())
                implementation(libs.findLibrary("orbit.mvi.viewModel").get())
                implementation(project(":uikit"))
            }
            configurePrimaryComposeAndroid(
                extensions.getByType<ApplicationExtension>(),
                kotlinCompileExtensionVersion
            )
        }
    }
}