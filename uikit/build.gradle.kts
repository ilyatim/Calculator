plugins {
    alias(libs.plugins.custom.android.library.compose)
}

android {
    namespace = "com.unfixedbo1t.calculator.uikit"

    buildFeatures {
        compose = true
    }
}

dependencies {

}