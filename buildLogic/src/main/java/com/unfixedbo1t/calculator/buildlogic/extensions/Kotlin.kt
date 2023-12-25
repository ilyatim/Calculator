package com.unfixedbo1t.calculator.buildlogic.extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal fun Project.configureKotlinAndroid(
    extension: CommonExtension<*, *, *, *, *>,
    compileVersion: Int,
    minVersion: Int
) {
    extension.apply {
        compileSdk = compileVersion

        defaultConfig {
            minSdk = minVersion
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        /*(this as ExtensionAware).extensions.configure<KotlinJvmOptions>("kotlinOptions") {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }*/
    }
}
