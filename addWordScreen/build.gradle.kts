plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)

    //Compose плагин
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    //Serialization
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    jvm()

    android {
        namespace = "com.example.addwordscreen"
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }
        minSdk = 27

        withHostTestBuilder {
        }

        androidResources {
            enable = true
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.compose.uiToolingPreview)
                implementation(libs.compose.uiTooling)
            }
        }

        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

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
        }

        jvmMain.dependencies {}

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.runner)
                implementation(libs.androidx.testExt.junit)
            }
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}