plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room3)
    alias(libs.plugins.koin.compiler)
}

room3 {
    schemaDirectory("$projectDir/schemas")
}

kotlin {
    jvm()

    android {
        namespace = "com.example.databasemodule"
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
            implementation(libs.androidx.room3.sqlite.wrapper)
        }

        commonMain.dependencies {
            implementation(libs.kotlin.stdlib)

            //Room
            implementation(libs.androidx.room3.runtime)
            implementation(libs.androidx.sqlite.bundled)

            //DI Koin Core
            implementation(libs.koin.core)
        }

        jvmMain.dependencies {}
    }
}

dependencies {
    add("kspAndroid", libs.androidx.room3.compiler)
    add("kspJvm", libs.androidx.room3.compiler)
}