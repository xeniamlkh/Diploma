import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    //Kotlin Multiplatform
    alias(libs.plugins.kotlinMultiplatform)

    //Compose плагин
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    //Android plugins
    alias(libs.plugins.androidMultiplatformLibrary)

    //Serialization
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    jvm()

    android {
        namespace = "com.example.diploma.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.compose.uiTooling)
        }
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            //Compose Multiplatform
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)

            //Resources (static content, such as images, fonts, and strings)
            api(libs.compose.components.resources)

            //Preview
            implementation(libs.compose.uiToolingPreview)

            //Navigation
            implementation(libs.jetbrains.navigation3.ui)

            //DI Koin Core
            implementation(libs.koin.core)

            //Koin Navigation
            implementation(libs.koin.navigation)

            //Koin ViewModel
            implementation(libs.koin.viewmodel)

            //Serialization
            implementation(libs.kotlinx.serialization)

            //Logs
            implementation(libs.kermit)

            implementation(projects.designLibrary)
            implementation(projects.databaseModule)
            implementation(projects.networkModule)
        }

        jvmMain.dependencies {}

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.coroutines.test)
            implementation(libs.compose.testing)
        }

        jvmTest.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }

        androidInstrumentedTest.dependencies {
            implementation(libs.androidx.test.junit4)
            implementation(libs.androidx.runner)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}