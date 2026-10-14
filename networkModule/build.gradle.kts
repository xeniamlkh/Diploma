plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    jvm()

    android {
        namespace = "com.example.networkmodule"
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

    sourceSets {
        androidMain.dependencies {
            //Ktor
            implementation(libs.ktor.client.okhttp)
        }

        commonMain.dependencies {
            implementation(libs.kotlin.stdlib)

            //Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.ktor.serialization)

            //DI Koin Core
            implementation(libs.koin.core)

            //Logs
            implementation(libs.kermit)
        }


        jvmMain.dependencies {
            //Ktor
            implementation(libs.ktor.client.okhttp)
            implementation(libs.ch.qos.logback)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.coroutines.test)
            implementation(libs.ktor.test)
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