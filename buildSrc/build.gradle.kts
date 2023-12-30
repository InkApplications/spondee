plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.9.21"))
    implementation("org.jetbrains.kotlinx:binary-compatibility-validator:0.13.2")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.10")
}
