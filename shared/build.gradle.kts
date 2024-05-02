import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.moko.resources)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // compose core
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.materialIconsExtended)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                // kotlin core
                implementation(libs.kotlin.serialization)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.datetime)

                // library for Skia and window management
                implementation(libs.skiko)

                // async image
                implementation(libs.kamel.image)

                // http client
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.serialization.json)
                implementation(libs.ktor.client.logging)

                // dependency injection
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                // logger
                implementation(libs.kermit)

                // navigator
                implementation(libs.voyager.koin)
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.screenmodel)
                implementation(libs.voyager.tab)
                implementation(libs.voyager.transition)

                // resource path
                api(libs.moko.resources)
                api(libs.moko.resources.compose)

                // local storage
                implementation(libs.kvault.storage)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)

            dependencies {
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.appcompat)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.koin.android)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "com.ilmal08.kmptemplate"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}