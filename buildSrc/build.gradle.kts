plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.dokka)
    implementation(libs.kotlinx.binary.compatibility)
}
