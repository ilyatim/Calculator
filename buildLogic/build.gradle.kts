plugins {
    `kotlin-dsl`
}

group = "com.unfixedbo1t.calculator.buildLogic"

dependencies {
    compileOnly(libs.gradle)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins.register("androidApplicationPlugin") {
        id = "com.unfixedbo1t.android.calculator.application"
        version = "1.0"
        implementationClass = "com.unfixedbo1t.calculator.buildlogic.plugins.ApplicationPlugin"
    }
    plugins.register("androidLibraryPlugin") {
        id = "com.unfixedbo1t.android.calculator.library"
        version = "1.0"
        implementationClass = "com.unfixedbo1t.calculator.buildlogic.plugins.LibraryPlugin"
    }
    plugins.register("androidDiPlugin") {
        id = "com.unfixedbo1t.android.calculator.di"
        version = "1.0"
        implementationClass = "com.unfixedbo1t.calculator.buildlogic.plugins.DiPlugin"
    }
    plugins.register("androidFeaturePlugin") {
        id = "com.unfixedbo1t.android.calculator.feature"
        version = "1.0"
        implementationClass = "com.unfixedbo1t.calculator.buildlogic.plugins.FeaturePlugin"
    }
}