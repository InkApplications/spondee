plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.7.20"))
    implementation("com.inkapplications.publishing:ink-publishing:1.0.0")
}
