package com.unfixedbo1t.calculator.buildlogic.extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configurePrimaryComposeAndroid(
    extension: CommonExtension<*, *, *, *, *>,
    kotlinCompileExtensionVersion: String
) {
    extension.apply {
        configureComposeOptions(extension, kotlinCompileExtensionVersion)
        configureBaseComposeDependencies()
    }
}

internal fun Project.configureBaseComposeDependencies(
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    dependencies {
        val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())
        implementation(composeBom)
        androidTestImplementation(composeBom)
        implementation(libs.findLibrary("androidx.compose.foundation").get())
        implementation(libs.findLibrary("androidx.compose.material").get())
        implementation(libs.findLibrary("androidx.compose.lifecycle.runtime").get())
        implementation(libs.findLibrary("androidx.compose.navigation").get())
        implementation(libs.findLibrary("androidx.compose.navigation.runtimeKtx").get())
        implementation(libs.findLibrary("androidx.compose.ui").get())
        implementation(libs.findLibrary("androidx.compose.ui.tooling").get())
        implementation(libs.findLibrary("androidx.compose.ui.tooling.preview").get())
    }
}

internal fun Project.configureComposeOptions(
    extension: CommonExtension<*, *, *, *, *>,
    kotlinCompileExtensionVersion: String
) {
    extension.apply {
        composeOptions {
            kotlinCompilerExtensionVersion = kotlinCompileExtensionVersion
        }
        buildFeatures {
            compose = true
        }
    }
}