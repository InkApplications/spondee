plugins {
    kotlin("multiplatform")
    id("maven-publish")
    id("org.jetbrains.kotlinx.binary-compatibility-validator")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    iosArm32()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    watchosArm32()
    watchosArm64()
    watchosX86()
    watchosX64()
    watchosSimulatorArm64()

    tvosArm64()
    tvosX64()
    tvosSimulatorArm64()

    macosX64()
    macosArm64()

    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    linuxX64()

    mingwX64()
    mingwX86()

    wasm {
        browser()
        nodejs()
        d8()
    }
    js {
        nodejs()
        browser()
    }

    sourceSets {
        val jvmTest by getting {
            dependencies {
                api(kotlin("test"))
                api(kotlin("test-annotations-common"))
                api(kotlin("test-junit"))
            }
        }
    }
}

apiValidation {
    nonPublicMarkers.add("inkapplications.spondee.format.SimpleNumberFormats")
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                name.set("Spondee: ${project.name}")
                description.set("A class set for wrapping units of measure in an application.")
                url.set("https://github.com/inkapplications/spondee")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://choosealicense.com/licenses/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("reneevandervelde")
                        name.set("Renee Vandervelde")
                        email.set("Renee@InkApplications.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/InkApplications/spondee.git")
                    developerConnection.set("scm:git:ssh://git@github.com:InkApplications/spondee.git")
                    url.set("https://github.com/InkApplications/spondee")
                }
            }
        }
    }
}
