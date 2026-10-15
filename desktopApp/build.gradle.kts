import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(project(":shared"))

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)
    implementation(libs.compose.uiToolingPreview)

    implementation(libs.compose.components.resources)

    //DI Koin Core
    implementation(libs.koin.core)
}

compose.desktop {
    application {
        mainClass = "com.example.diploma.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.example.diploma"
            packageVersion = "1.0.0"

            windows { iconFile.set(project.file("ic_diploma_ico.ico")) }
        }
    }
}