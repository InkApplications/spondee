plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js {
        nodejs()
        browser()
    }
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxX64()
    mingwX64()
    macosX64()

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
