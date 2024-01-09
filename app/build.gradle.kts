plugins {
    alias(libs.plugins.custom.android.application)
}

android {
    namespace = "com.unfixedbo1t.calculator"

    defaultConfig {
        applicationId = "com.unfixedbo1t.calculator"
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

android.sourceSets.all {
    java.srcDir("src/$name/kotlin")
}

dependencies {
    implementation(project(":feature:simpleCalculator"))
    implementation(libs.androidx.material3.window.size)
    implementation(libs.koin.androidx.compose)
    implementation(libs.androidx.compose.constraintLayout)
}