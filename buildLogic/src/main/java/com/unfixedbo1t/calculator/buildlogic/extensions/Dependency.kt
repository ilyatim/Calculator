@file:Suppress("unused")

package com.unfixedbo1t.calculator.buildlogic.extensions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

private const val implementation: String = "implementation"
private const val implementationToPattern: String = "Implementation"

const val androidMainSourceSet: String = "androidMain"
const val commonMainSourceSet: String = "commonMain"
const val androidTestSourceSet: String = "androidTest"

internal fun DependencyHandler.implementation(
    notation: Any,
    sourceSetName: String = ""
): Dependency? {
    val name = if (sourceSetName.isNotBlank()) {
        "$sourceSetName$implementationToPattern"
    } else {
        implementation
    }
    return add(name, notation)
}

internal fun DependencyHandler.androidMainImplementation(notation: Any): Dependency? =
    implementation(notation, androidMainSourceSet)

internal fun DependencyHandlerScope.commonMainImplementation(notation: Any): Dependency? =
    implementation(notation, commonMainSourceSet)

internal fun DependencyHandlerScope.androidTestImplementation(notation: Any): Dependency? =
    implementation(notation, androidTestSourceSet)

internal fun DependencyHandlerScope.testImplementation(notation: Any): Dependency? =
    add("testImplementation", notation)

internal fun DependencyHandlerScope.debugImplementation(notation: Any): Dependency? =
    add("debugImplementation", notation)

internal fun DependencyHandlerScope.kapt(notation: Any): Dependency? =
    add("kapt", notation)

internal fun DependencyHandlerScope.kaptAndroidTest(notation: Any): Dependency? =
    add("kaptAndroidTest", notation)

internal fun DependencyHandlerScope.runtimeOnly(notation: Any): Dependency? =
    add("runtimeOnly", notation)