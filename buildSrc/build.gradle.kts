plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.7.21"))
    implementation("com.inkapplications.publishing:ink-publishing:1.0.0")
}
