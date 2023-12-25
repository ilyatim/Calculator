package com.unfixedbo1t.calculator.buildlogic.plugins

import com.android.build.api.dsl.LibraryExtension
import com.unfixedbo1t.calculator.buildlogic.extensions.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class LibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            val minSdk = libs.findVersion("android.minSdkVersion").get().requiredVersion
            val compileSdk = libs.findVersion("android.compileSdkVersion").get().requiredVersion
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this, compileSdk.toInt(), minSdk.toInt())
            }
        }
    }
}