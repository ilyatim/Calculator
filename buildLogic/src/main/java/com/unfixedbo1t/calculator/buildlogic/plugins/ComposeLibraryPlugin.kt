package com.unfixedbo1t.calculator.buildlogic.plugins

import com.android.build.api.dsl.LibraryExtension
import com.unfixedbo1t.calculator.buildlogic.extensions.configurePrimaryComposeAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class ComposeLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.unfixedbo1t.android.calculator.library")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            val kotlinCompileExtensionVersion = libs.findVersion("kotlin.compose").get().requiredVersion
            extensions.configure<LibraryExtension> {
                configurePrimaryComposeAndroid(this, kotlinCompileExtensionVersion)
            }
        }
    }
}