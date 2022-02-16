plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.6.10"))
    implementation("com.inkapplications.publishing:ink-publishing:1.0.0")
}
