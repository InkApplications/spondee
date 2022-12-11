plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.7.21"))
    implementation("com.inkapplications.publishing:ink-publishing:1.0.0")
    implementation("org.jetbrains.kotlinx:binary-compatibility-validator:0.12.1")
}
