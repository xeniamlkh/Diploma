plugins {
    //Kotlin Multiplatform - главный плагин KMP
    alias(libs.plugins.kotlinMultiplatform)

    //Compose плагин
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    //Android
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)
}

kotlin {
    jvm()

    android {
        namespace = "com.example.designlibrary"
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }
        minSdk = 27

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    val xcfName = "designLibraryKit"

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

                //Compose Multiplatform
                implementation(libs.compose.foundation)
                implementation(libs.compose.runtime)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)

                //Resources (static content, such as images, fonts, and strings)
                implementation(libs.compose.components.resources)

                //Design
                //implementation(libs.material.icons)

                //Preview
                implementation(libs.compose.uiToolingPreview)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {}
        }

        jvmMain.dependencies {}

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.runner)
                implementation(libs.androidx.testExt.junit)
            }
        }
    }
}

// Custom resource directories c publicResClass = true
compose.resources {
    //publicResClass set to true makes the generated Res class public
    publicResClass = true

    //the generated Res class is assigned to a package "ru.poly.designSystem.resources"
    packageOfResClass = "com.example.designlibrary.resources"

    //the Res class is generated only if the project has an explicit implementation or
    // api dependency on the resource library
    generateResClass = always
}